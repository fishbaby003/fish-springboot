package com.fish.replay.util;

import lombok.Data;

/**
 * @author fish
 */
@Data
public class Result {
    private int code;
    private String msg;
    private Data data;
    private boolean success;
}
