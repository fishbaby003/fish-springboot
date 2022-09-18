package com.fish.mybatis.mapper;

import com.fish.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fish
 */
@Repository
public interface UserMapper {
    /**
     * select by id
     * @param id
     * @return
     */
    User sel(int id);

    /**
     * select by repUserName
     * @return
     */
    List<User> getRepUserName();

    /**
     * create temptable
     * @param num
     */
    void createTempTable(@Param("num")Integer num);

    /**
     * drop table
     */
    void dropTable();
}