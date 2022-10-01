package com.fish.elasticsearch.util;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.CountRequest;
import org.elasticsearch.client.core.CountResponse;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.util.CollectionUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**

 * es RestHighLevelClient 工具类
 * @author fish
 */
   @Slf4j
   @Component
   public class EsUtil {

   private static final long TIME_OUT = 60;

   @Resource
   RestHighLevelClient highLevelClient;

   /**

    * 根据条件获取索引总数
    * @param index
    * @param query
    * @return
      */
      public long getTotalHits(String index,QueryBuilder query){
      CountRequest countRequest = new CountRequest();
      CountResponse response;
      // 绑定索引名
      countRequest.indices(index);
      countRequest.query(query);
      try {
          response = highLevelClient.count(countRequest, RequestOptions.DEFAULT);
          return response.getCount();
      } catch (IOException e) {
          e.printStackTrace();
      }
      return 0;
      }

   /**
    * 根据条件分页查询指定索引数据
    * @param index ES索引
    * @param from 开始数
    * @param size 大小
    * @param orderName 排序字段名
    * @param sortOrder 排序方式
    * @param includes 返回字段
    * @param query 查询条件
    * @return
      */
      public Map<String, Object> searchPage(String index, int from, int size, String orderName, String sortOrder,
                                               String[] includes, BoolQueryBuilder query) {
      Map<String, Object> resultMap = new HashMap<>();
      SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
      sourceBuilder.query(query).from((from - 1) * size).size(size)
              .timeout(new TimeValue(TIME_OUT, TimeUnit.SECONDS));
      if (!StringUtils.isEmpty(orderName) && !StringUtils.isEmpty(sortOrder)) {
          sourceBuilder.sort(new FieldSortBuilder(orderName).order(SortOrder.fromString(sortOrder)));
      } else {
          sourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
      }
      // 返回列和排除列,排除列可设置为null
      if (!CollectionUtils.isEmpty(includes)) {
          sourceBuilder.fetchSource(includes,null);
      }
      SearchRequest searchRequest = new SearchRequest(index).source(sourceBuilder);
      try{
          log.info("searchRequest:" + searchRequest.toString());
          SearchResponse response = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
          List<String> data = new ArrayList<>();
          for(SearchHit hit : response.getHits().getHits()){
              String hitSourceAsString = hit.getSourceAsString();
              data.add(hitSourceAsString);
          }
          List<Map<String,Object>> map = new ArrayList<>();
          for(SearchHit hit : response.getHits().getHits()){
              Map<String,Object> hitSourceAsMap = hit.getSourceAsMap();
              map.add(hitSourceAsMap);
          }
//          resultMap.put("records", JSONObject.toJSONString(data));
//          resultMap.put("records",response.getHits().getHits());
          resultMap.put("records",map);
          //总数
          resultMap.put("total",getTotalHits(index,query));
          //当前页数
          resultMap.put("current",from);
          //每页条数
          resultMap.put("rowCount",size);
          return resultMap;
      } catch (IOException e) {
          e.printStackTrace();
      }
      return null;
      }
   }
