package com.fish.elasticsearch.dao;

import com.fish.elasticsearch.entity.Poetry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 关系型数据库mysql Repository
 *
 * @author fish
 * 2022/10/1
 */
@Repository("poetryDao")
public interface PoetryDao extends JpaRepository<Poetry, String> {

    /**
     * 根据标题或者内容查询
     *
     * @param poetryTitle
     * @param originalText
     * @return
     */
    List<Poetry> findPoetryByPoetryTitleOrOriginalText(String poetryTitle, String originalText);
}