package com.fish.elk.vo;

import lombok.Data;

/**
 * @Description: Controller层的日志封装类
 * @Author: fish
 * @Date: 2023/11/19 16:01
 */
@Data
public class WebLog {

    /**
     * 操作描述
     */
    private String description;

    /**
     * 操作用户
     */
    private String username;

    /**
     * 操作时间
     */
    private Long startTime;

    /**
     * 消耗时间
     */
    private long spendTime;

    /**
     * 根路径
     */
    private String basePath;

    /**
     * URI
     */
    private String uri;

    /**
     * URL
     */
    private String url;

    /**
     * 请求类型
     */
    private String method;

    /**
     * IP地址
     */
    private String ip;

    private Object parameter;

    private Object result;


}
