package com.fish.elasticsearch.dao;

import com.fish.elasticsearch.entity.EsPoetry;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ES EsPoetry repository
 *
 * @author fish
 * 2022/10/1
 */
@Repository("esPoetryRepository")
public interface EsPoetryRepository extends ElasticsearchRepository<EsPoetry, String> {

    /**
     * 根据标题或者作者查询
     * @param poetryTitle
     * @param author
     * @return
     */
    List<EsPoetry> findByPoetryTitleOrAuthor(String poetryTitle, String author);

    /**
     * @param keyword
     * @return
     */
    @Highlight(fields = {
            @HighlightField(name = "poetryTitle"),
            @HighlightField(name = "author")
    })
    @Query("{\"match\":{\"poetryTitle\":\"?0\"}}")
    SearchHits<EsPoetry> find(String keyword);
}