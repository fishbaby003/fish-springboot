
package com.fish.feign.entity;


import lombok.Data;

import java.util.List;

/**
 * 秒杀商品返回实体类
 * @author fish
 */
@Data
public class MiaoShaProduct {

    private int code;
    private String msg;
    private Data data;
    private boolean success;
    @lombok.Data
    public static class Data {
        private Taps taps;
    }

    @lombok.Data
    public static class Taps {
        private int id;
        private int activityId;
        private long startTime;
        private long endTime;
        private int status;
        private long serverTime;
        private List<ProductList> productList;
        private boolean valid;
    }

    @lombok.Data
    public static class ProductList {
        private long actCommodityId;
        private int brandId;
        private String brandName;
        private int categoryId;
        private String categoryName;
        private long spuId;
        private String spuName;
        private long skuId;
        private String skuCode;
        private String commodityName;
        private int actPrice;
        private int salePrice;
        private int marketPrice;
        private int actStore;
        private int usedStore;
        private String promotionLabel;
        private ActCorner actCorner;
        private int marketable;
        private Image image;
        private int orderNo;
        private int actState;
        private String actCode;
        private String actName;
        private int actRemindTime;
        private int actType;
        private int actSubType;
        private int remindTag;
        private int remindTimeAmount;
        private int remindTimeUnit;
        private int remindState;
        private int remindCount;
    }
    @lombok.Data
    public static class ActCorner {
        private String originalPic;
        private String thumbnailPic;
        private String smallPic;
        private String bigPic;
    }
    @lombok.Data
    public static class Image {
        private String thumbnailPic;
        private String smallPic;
        private String middlePic;
        private String bigPic;
        private String hdPic;
    }

}