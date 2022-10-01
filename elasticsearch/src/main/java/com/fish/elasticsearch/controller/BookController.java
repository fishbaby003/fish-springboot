//package com.fish.elasticsearch.controller;
//
//import com.fish.elasticsearch.entity.Book;
//import com.fish.elasticsearch.entity.EsBook;
//import com.fish.elasticsearch.service.BookService;
//import com.fish.elasticsearch.util.Result;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.elasticsearch.core.SearchHits;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @author fish
// * 2022/09/09
// */
//@RestController
//public class BookController {
//    @Autowired
//    private BookService bookService;
//
//    /**
//     * 添加书籍
//     *
//     * @param book
//     * @return
//     */
//    @PostMapping("/addBook")
//    public Result addBook(@RequestBody Book book) {
//        bookService.addBook(book);
//        return Result.succeed(book, "操作成功");
//    }
//
//    /**
//     * 根据关键词查询书籍
//     *
//     * @param key
//     * @return
//     */
//    @GetMapping("/book/search")
//    public SearchHits<EsBook> search(String key) {
//        return bookService.searchBook1(key);
//    }
//
//    /**
//     * 根据关键词查询书籍（JPA查询）
//     *
//     * @param key
//     * @return
//     */
//    @GetMapping("/book/search/es")
//    public List<EsBook> searchEs(String key) {
//        return bookService.searchBook(key);
//    }
//
//    /**
//     * 根据关键字查询mysql书籍表
//     *
//     * @param key
//     * @return
//     */
//    @GetMapping("/book/searchByMysql")
//    public List<Book> searchByMysql(String key) {
//        return bookService.searchBookFromMysql(key);
//    }
//
//
//    /**
//     * 删除书籍
//     *
//     * @param book
//     * @return
//     */
//    @PostMapping("/deleteBook")
//    public Result deleteBook(@RequestBody Book book) {
//        bookService.deleteBook(book.getId());
//        return Result.succeed("操作成功");
//    }
//
//    /**
//     * es分页查询书籍
//     * @param current
//     * @param rowCount
//     * @param title
//     * @param author
//     * @return
//     */
//    @GetMapping("/book/getEsBookByPage")
//    public Map<String, Object> getEsBookByPage(@RequestParam(value="current") int current, @RequestParam(value="rowCount") int rowCount
//            , @RequestParam(value="title",required=false) String title
//            , @RequestParam(value="author",required=false) String author) {
//        return bookService.getEsBookByPage(current,rowCount,title, author);
//    }
//}