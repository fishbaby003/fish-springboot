//package com.fish.elasticsearch.service;
//
//import com.fish.elasticsearch.entity.Book;
//import com.fish.elasticsearch.entity.EsBook;
//import com.fish.elasticsearch.util.PageResult;
//import org.springframework.data.elasticsearch.core.SearchHits;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @author fish
// */
//public interface BookService {
//    /**
//     * 添加书籍
//     * @param book
//     */
//    void addBook(Book book);
//
//    /**
//     * 根据关键词查询书籍（JPA查询）
//     * @param keyword
//     * @return List<EsBook>
//     */
//    List<EsBook> searchBook(String keyword);
//
//    /**
//     * 根据关键词查询书籍
//     * @param keyword
//     * @return
//     */
//    SearchHits<EsBook> searchBook1(String keyword);
//
//    /**
//     * 根据关键字查询mysql书籍表
//     * @param key
//     * @return
//     */
//    List<Book> searchBookFromMysql(String key);
//
//    /**
//     * 删除书籍
//     * @param id
//     */
//    void deleteBook(String id);
//
//    /**
//     * es分页查询书籍
//     * @param current
//     * @param rowCount
//     * @param title
//     * @param author
//     * @return
//     */
//    Map<String, Object> getEsBookByPage(int current, int rowCount,  String title, String author);
//}
