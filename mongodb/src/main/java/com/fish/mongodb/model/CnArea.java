package com.fish.mongodb.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

/**
 * 中国行政地区表
 * @author fish
 */
@Data
@Document(value = "cn_area")
public class CnArea {
    /**
     * 主键
     */
    private Integer id;
    /**
     *级别
     */
    private Integer level;
    /**
     *父级行政代码
     */
    @Field(value = "parent_code")
    private String parentCode;
    /**
     * 行政代码
     */
    @Field(value = "area_code")
    private String areaCode;
    /**
     * 邮政编码
     */
    @Field(value = "zip_code")
    private Integer zipCode;
    /**
     * 区号
     */
    @Field(value = "city_code")
    private String cityCode;
    /**
     * 名称
     */
    private String name;
    /**
     * 简称
     */
    @Field(value = "short_name")
    private String shortName;
    /**
     * 组合名
     */
    @Field(value = "merger_name")
    private String mergerName;
    /**
     * 拼音
     */
    private String pinyin;
    /**
     * 经度
     */
    private String lng;
    /**
     * 纬度
     */
    private String lat;
}
