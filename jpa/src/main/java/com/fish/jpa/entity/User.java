package com.fish.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户实体类
 * @author fish
 */
@Entity
@Data
@Table(name = "user")
@org.hibernate.annotations.Table(appliesTo = "user", comment = "用户表")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "int(11) comment 'id 主键,自增'")
    private Integer id;
    @Column(name = "name",columnDefinition = "varchar(32) comment '姓名'")
    private String name;
    @Column(name = "age",columnDefinition = "varchar(3) comment '年龄'")
    private String age;
    @Column(name = "sex",columnDefinition = "varchar(4) comment '性别'")
    private String sex;
    @Column(name = "tel",columnDefinition = "varchar(11) comment '电话号码'")
    private String tel;
    @Column(name = "brithday",columnDefinition = "datetime comment '生日'")
    private Date brithday;
    @Column(name = "marks",columnDefinition = "varchar(32) comment '标记'")
    private String marks;
    @Column(name = "address",columnDefinition = "varchar(256) comment '地址'")
    private String address;

}