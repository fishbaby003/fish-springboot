package com.fish.shardingjdbc.mapper;

import com.fish.shardingjdbc.entity.Address;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author fish
 */
@Mapper
public interface AddressMapper {
    /**
     * 保存
     */
    void save(Address address);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    Address get(Long id);
}