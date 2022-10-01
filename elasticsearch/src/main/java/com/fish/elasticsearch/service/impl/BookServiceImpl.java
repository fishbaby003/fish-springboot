//package com.fish.elasticsearch.service.impl;
//
//
//import com.fish.elasticsearch.dao.BookDao;
//import com.fish.elasticsearch.dao.ESBookRepository;
//import com.fish.elasticsearch.entity.Book;
//import com.fish.elasticsearch.entity.EsBook;
//import com.fish.elasticsearch.service.BookService;
//import com.fish.elasticsearch.util.EsUtil;
//import com.fish.elasticsearch.util.PageResult;
//import lombok.extern.slf4j.Slf4j;
//import org.elasticsearch.action.search.SearchRequest;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.client.RequestOptions;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.elasticsearch.index.query.BoolQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.SearchHit;
//import org.elasticsearch.search.builder.SearchSourceBuilder;
//import org.elasticsearch.search.sort.SortOrder;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.elasticsearch.core.SearchHits;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.support.TransactionTemplate;
//import org.springframework.util.StringUtils;
//
//import javax.annotation.Resource;
//import java.io.IOException;
//import java.util.*;
//
///**
// * @author fish
// * 2022/09/09
// */
//@Slf4j
//@Service
//public class BookServiceImpl implements BookService {
//    @Autowired
//    private BookDao bookDao;
//    @Autowired
//    private ESBookRepository esBookRepository;
//    @Autowired
//    private TransactionTemplate transactionTemplate;
//
//    @Resource
//    RestHighLevelClient restHighLevelClient;
//    @Resource
//    EsUtil esUtil;
//
//
//    @Override
//    public void addBook(Book book) {
//        /*SnowUtil snowFlake = new SnowUtil(2, 3);
//        book.setId(snowFlake.nextId()+"");*/
//        final Book saveBook = transactionTemplate.execute((status) ->
//                bookDao.save(book)
//        );
//        final EsBook esBook = new EsBook();
//        assert saveBook != null;
//        BeanUtils.copyProperties(saveBook, esBook);
//        esBook.setId(saveBook.getId());
//        try {
//            esBookRepository.save(esBook);
//        } catch (Exception e) {
//            log.error(String.format("保存ES错误！%s", e.getMessage()));
//        }
//    }
//
//    @Override
//    public List<EsBook> searchBook(String keyword) {
//        return esBookRepository.findByTitleOrAuthor(keyword, keyword);
//    }
//
//    @Override
//    public SearchHits<EsBook> searchBook1(String keyword) {
//        return esBookRepository.find(keyword);
//    }
//
//    @Override
//    public List<Book> searchBookFromMysql(String key) {
//        return bookDao.findBookByAuthorOrTitle(key, key);
//    }
//
//    @Override
//    public void deleteBook(String id) {
//        //es删除
//        esBookRepository.deleteById(id);
//        try {
//            //mysql删除
//        bookDao.deleteById(id);
//        } catch (Exception e) {
//            log.error(String.format("mysql删除书籍错误！%s", e.getMessage()));
//        }
//    }
//
//    @Override
//    public Map<String, Object> getEsBookByPage(int current, int rowCount,String title, String author) {
//
//        BoolQueryBuilder query=QueryBuilders.boolQuery();
//        if(!StringUtils.isEmpty(author)) {
//            query.must(QueryBuilders.matchAllQuery())
//                .filter(QueryBuilders.wildcardQuery("author.keyword", "*" + author + "*"));
//        }
//        if(!StringUtils.isEmpty(title)) {
//            query.must(QueryBuilders.matchAllQuery())
////                .filter(QueryBuilders.rangeQuery("title.keyword").gt(title));
//                    .filter(QueryBuilders.wildcardQuery("title.keyword", "*" + title + "*"));
//        }
//        Map<String, Object> map=esUtil.searchPage("book",current,rowCount,"id.keyword","asc",null,query);
//        return map;
//    }
//    /**
//     * @Description search_after 深分页
//     * @create by fish
//     */
//    private void docSearch(String title,String author) {
//        List<SearchHit> searchHits = new ArrayList<>();
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        BoolQueryBuilder builder = QueryBuilders.boolQuery();
//        builder.must(QueryBuilders.matchAllQuery())
//                .filter(QueryBuilders.rangeQuery("title").gt(title));
//        try {
//            searchSourceBuilder.query(builder)
//                    .sort("id", SortOrder.ASC)
////                    .sort("title", SortOrder.ASC)
//                    .from(0)
//                    .size(10);
//            SearchRequest searchRequest = new SearchRequest("docker-elasticsearch").source(searchSourceBuilder);
//            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//            SearchHit[] hits = searchResponse.getHits().getHits();
//            //查询最后一个数据
//            SearchHit result = hits[hits.length - 1];
//            //分页查询下一页数据
//            SearchSourceBuilder searchSourceBuilder2 = new SearchSourceBuilder();
//            searchSourceBuilder2.query(builder)
//                    .sort("id", SortOrder.ASC)
////                    .sort("title", SortOrder.ASC)
//                    .size(10);
//            //存储上一次分页的sort信息
//            searchSourceBuilder2.searchAfter(result.getSortValues());
//            SearchRequest searchRequest2 = new SearchRequest("docker-elasticsearch").source(searchSourceBuilder2);
//            SearchResponse searchResponse2 = restHighLevelClient.search(searchRequest2, RequestOptions.DEFAULT);
//            SearchHit[] hits2 = searchResponse2.getHits().getHits();
//        } catch (IOException e) {
//            log.error("doc分页查询异常:{} ", e);
//        }
//    }
//}