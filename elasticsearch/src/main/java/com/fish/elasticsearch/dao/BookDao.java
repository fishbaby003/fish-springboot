//package com.fish.elasticsearch.dao;
//
//import com.fish.elasticsearch.entity.Book;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
///**
// * 关系型数据库mysql Repository
// *
// * @author fish
// * 2022/09/09
// */
//@Repository("bookDao")
//public interface BookDao extends JpaRepository<Book, String> {
//
//    /**
//     * 根据作者或者标题查询
//     *
//     * @param author
//     * @param title
//     * @return
//     */
//    List<Book> findBookByAuthorOrTitle(String author, String title);
//}