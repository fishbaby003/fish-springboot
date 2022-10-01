package com.fish.elasticsearch.service;

import com.fish.elasticsearch.entity.EsPoetry;
import com.fish.elasticsearch.entity.Poetry;
import org.springframework.data.elasticsearch.core.SearchHits;

import java.util.List;
import java.util.Map;

/**
 * @author fish
 */
public interface PoetryService {
    /**
     * 添加古诗
     * @param poetry
     */
    void addPoetry(Poetry poetry);

    /**
     * 根据关键词查询古诗（JPA查询）
     * @param keyword
     * @return List<EsPoetry>
     */
    List<EsPoetry> searchPoetry(String keyword);

    /**
     * 根据关键词查询古诗
     * @param keyword
     * @return
     */
    SearchHits<EsPoetry> searchPoetry1(String keyword);

    /**
     * 根据关键字查询mysql书古诗
     * @param key
     * @return
     */
    List<Poetry> searchPoetryFromMysql(String key);

    /**
     * 删除古诗
     * @param id
     */
    void deletePoetry(String id);

    /**
     * es分页查询古诗
     * @param current
     * @param rowCount
     * @param poetryTitle
     * @param author
     * @return
     */
    Map<String, Object> getEsPoetryByPage(int current, int rowCount, String poetryTitle, String author);
}
