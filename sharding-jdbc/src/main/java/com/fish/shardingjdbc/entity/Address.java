package com.fish.shardingjdbc.entity;

import lombok.Data;

/**
 * @author fish
 */
@Data
public class Address {
    private Long id;
    private String code;
    private String name;
    private String pid;
    private Integer type;
    private Integer lit;
}