package com.fish.feign.entity.request;

import lombok.Data;

/**
 * 活动商品请求参数
 * @author fish
 */
@Data
public class ActAllowSellReq {
    private Integer skuId;
    private Integer num;
    private String bSkuIds;
    private String suiteCode;
    private String sSkuIds;
    private String actCode;
    /**
     * 时间戳类型时间
     */
    private long t;
}
