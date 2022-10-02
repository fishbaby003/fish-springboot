package com.fish.shardingjdbc.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author fish
 */
@Data
public class User {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private Integer cityId;
    private Date createTime;
    private Integer sex;
}