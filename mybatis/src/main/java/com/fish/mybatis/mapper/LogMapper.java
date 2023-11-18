package com.fish.mybatis.mapper;

import com.fish.mybatis.entity.Log;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author fish
 */
@Repository
public interface LogMapper {
    /**
     * query Log by id
     * @param id
     * @return
     */
    Log getById(int id);

    /**
     * query count
     * @return
     */
    int getCount();

    /**
     * query all Log by list
     * @return
     */
    List<Log> getByAll();

    /**
     * query Log by page
     * @param data
     * @return
     */
    List<Log> queryLogsBySql(Map<String, Object> data);
}