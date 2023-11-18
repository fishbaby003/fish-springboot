package com.fish.feign.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fish
 */
@Data
public class Result<T> implements Serializable {
    private int code;
    private boolean success;
    private T data;
    private String msg;

    private Result(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.success = code == 200;
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(200, data, "success");
    }

    public static <T> Result<T> error(String msg) {
        return new Result<>(500, null, msg);
    }
}