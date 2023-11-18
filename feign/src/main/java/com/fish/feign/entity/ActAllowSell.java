package com.fish.feign.entity;

import lombok.Data;

import java.util.List;

/**
 * 活动商品
 * @author fish
 */
@Data
public class ActAllowSell {
    private int code;
    private String msg;
    private Data data;

    @lombok.Data
    public static class Data {
        private int status;
        private String message;
        private int marketable;
        private List<ActSkus> actSkus;
    }

    @lombok.Data
    public static class ActSkus {
        private String spuId;
        private String skuId;
        private int marketPrice;
        private int actPrice;
        private String actState;
        private String prodName;
        private String picUrl;
        private String actStateDesc;
        private String prodUrl;
    }

}
