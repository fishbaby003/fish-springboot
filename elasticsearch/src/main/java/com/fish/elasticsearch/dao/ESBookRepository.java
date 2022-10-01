//package com.fish.elasticsearch.dao;
//
//import com.fish.elasticsearch.entity.EsBook;
//import org.springframework.data.elasticsearch.annotations.Highlight;
//import org.springframework.data.elasticsearch.annotations.HighlightField;
//import org.springframework.data.elasticsearch.annotations.Query;
//import org.springframework.data.elasticsearch.core.SearchHits;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
///**
// * ES EsBook repository
// *
// * @author fish
// * 2022/09/09
// */
//@Repository("esBookRepository")
//public interface ESBookRepository extends ElasticsearchRepository<EsBook, String> {
//
//    /**
//     * @param title
//     * @param author
//     * @return
//     */
//    List<EsBook> findByTitleOrAuthor(String title, String author);
//
//    /**
//     * @param keyword
//     * @return
//     */
//    @Highlight(fields = {
//            @HighlightField(name = "title"),
//            @HighlightField(name = "author")
//    })
//    @Query("{\"match\":{\"title\":\"?0\"}}")
//    SearchHits<EsBook> find(String keyword);
//}