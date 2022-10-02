package com.fish.shardingjdbc.mapper;

import com.fish.shardingjdbc.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author fish
 */
@Mapper
public interface UserMapper {
    /**
     * 保存
     */
    void save(User user);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    User get(Long id);
}