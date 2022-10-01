package com.fish.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author fish
 * 2022/10/1
 */
@Data
@Document(indexName = "poetry_index", createIndex = true)
public class EsPoetry {
    @Id
    @Field(type = FieldType.Text)
    private String id;
    /**
     * 标题
     */
    @Field(analyzer = "ik_max_word")
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
    @Field(analyzer = "ik_max_word")
    private String originalText;
}