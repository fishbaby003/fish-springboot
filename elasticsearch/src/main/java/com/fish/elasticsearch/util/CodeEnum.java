package com.fish.elasticsearch.util;

/**
 * @Author: fish
 */
public enum CodeEnum {
    SUCCESS(200),
    ERROR(500);

    private Integer code;
    CodeEnum(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
