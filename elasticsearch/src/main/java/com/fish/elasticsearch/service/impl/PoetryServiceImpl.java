package com.fish.elasticsearch.service.impl;


import com.fish.elasticsearch.dao.EsPoetryRepository;
import com.fish.elasticsearch.dao.PoetryDao;
import com.fish.elasticsearch.entity.Poetry;
import com.fish.elasticsearch.entity.EsPoetry;
import com.fish.elasticsearch.service.PoetryService;
import com.fish.elasticsearch.util.EsUtil;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author fish
 * 2022/10/1
 */
@Slf4j
@Service
public class PoetryServiceImpl implements PoetryService {
    @Autowired
    private PoetryDao poetryDao;
    @Autowired
    private EsPoetryRepository esPoetryRepository;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Resource
    RestHighLevelClient restHighLevelClient;
    @Resource
    EsUtil esUtil;


    @Override
    public void addPoetry(Poetry poetry) {
        final Poetry savePoetry = transactionTemplate.execute((status) ->
                poetryDao.save(poetry)
        );
        final EsPoetry esPoetry = new EsPoetry();
        assert savePoetry != null;
        BeanUtils.copyProperties(savePoetry, esPoetry);
        esPoetry.setId(savePoetry.getId());
        try {
            esPoetryRepository.save(esPoetry);
        } catch (Exception e) {
            log.error(String.format("保存ES错误！%s", e.getMessage()));
        }
    }

    @Override
    public List<EsPoetry> searchPoetry(String keyword) {
        return esPoetryRepository.findByPoetryTitleOrAuthor(keyword, keyword);
    }

    @Override
    public SearchHits<EsPoetry> searchPoetry1(String keyword) {
        return esPoetryRepository.find(keyword);
    }

    @Override
    public List<Poetry> searchPoetryFromMysql(String key) {
        return poetryDao.findPoetryByPoetryTitleOrOriginalText(key, key);
    }

    @Override
    public void deletePoetry(String id) {
        //es删除
        esPoetryRepository.deleteById(id);
        try {
            //mysql删除
            poetryDao.deleteById(id);
        } catch (Exception e) {
            log.error(String.format("mysql删除古诗错误！%s", e.getMessage()));
        }
    }

    @Override
    public Map<String, Object> getEsPoetryByPage(int current, int rowCount,String poetryTitle, String author) {

        BoolQueryBuilder query=QueryBuilders.boolQuery();
        if(!StringUtils.isEmpty(author)) {
            query.must(QueryBuilders.matchAllQuery())
                .filter(QueryBuilders.wildcardQuery("author.keyword", "*" + author + "*"));
        }
        if(!StringUtils.isEmpty(poetryTitle)) {
            query.must(QueryBuilders.matchAllQuery())
                    .filter(QueryBuilders.wildcardQuery("poetryTitle.keyword", "*" + poetryTitle + "*"));
        }
        Map<String, Object> map=esUtil.searchPage("poetry_index",current,rowCount,"poetryTitle.keyword","asc",null,query);
        return map;
    }
    /**
     * @Description search_after 深分页
     * @create by fish
     */
    private void docSearch(String poetryTitle,String author) {
        List<SearchHit> searchHits = new ArrayList<>();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        builder.must(QueryBuilders.matchAllQuery())
                .filter(QueryBuilders.rangeQuery("poetryTitle").gt(poetryTitle));
        try {
            searchSourceBuilder.query(builder)
                    .sort("id", SortOrder.ASC)
                    .from(0)
                    .size(10);
            SearchRequest searchRequest = new SearchRequest("docker-elasticsearch").source(searchSourceBuilder);
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            SearchHit[] hits = searchResponse.getHits().getHits();
            //查询最后一个数据
            SearchHit result = hits[hits.length - 1];
            //分页查询下一页数据
            SearchSourceBuilder searchSourceBuilder2 = new SearchSourceBuilder();
            searchSourceBuilder2.query(builder)
                    .sort("id", SortOrder.ASC)
                    .size(10);
            //存储上一次分页的sort信息
            searchSourceBuilder2.searchAfter(result.getSortValues());
            SearchRequest searchRequest2 = new SearchRequest("docker-elasticsearch").source(searchSourceBuilder2);
            SearchResponse searchResponse2 = restHighLevelClient.search(searchRequest2, RequestOptions.DEFAULT);
            SearchHit[] hits2 = searchResponse2.getHits().getHits();
        } catch (IOException e) {
            log.error("doc分页查询异常:{} ", e);
        }
    }
}