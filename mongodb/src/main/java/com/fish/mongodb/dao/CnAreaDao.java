package com.fish.mongodb.dao;

import com.fish.mongodb.model.CnArea;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author fish
 */
public interface CnAreaDao extends MongoRepository<CnArea, Long> {
    /**
     * 根据标题模糊查询
     *
     * @param name 名字
     * @return 满足条件的行政区域名
     */
    List<CnArea> findByNameLike(String name);
}
