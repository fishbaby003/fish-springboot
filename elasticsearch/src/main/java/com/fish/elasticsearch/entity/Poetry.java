package com.fish.elasticsearch.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * mysql 存储poetry
 *
 * @author fish
 * @since 2022/10/1 11:33
 */
@Data
@Entity(name = "t_poetry")
public class Poetry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    /**
     * 标题
     */
    @Column(name = "poetry_title")
    private String poetryTitle;
    /**
     * 朝代
     */
    private String dynasty;
    /**
     * 作者
     */
    private String author;
    /**
     * 内容
     */
    @Column(name = "original_text")
    private String originalText;
}
