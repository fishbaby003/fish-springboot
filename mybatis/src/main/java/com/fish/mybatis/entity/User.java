package com.fish.mybatis.entity;

import lombok.Data;

/**
 * @author fish
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;
}