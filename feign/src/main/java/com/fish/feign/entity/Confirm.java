package com.fish.feign.entity;

import lombok.Data;

import java.util.List;

/**
 * 确认购买信息
 * @author fish
 */
@Data
public class Confirm {

    private int code;
    private String msg;
    private Data data;

    @lombok.Data
    public static class Data {

        private String requestUuid;
        private List<Addresses> addresses;
        private List<PayMethods> payMethods;
        private boolean payMethodsDisplay;
        private List<CommodityPackages> commodityPackages;
        private SettleInfo settleInfo;
        private UserOrderPromo userOrderPromo;
        private String sourceAgent;
        private String laserConfirmUrl;
        private String buyMode;
        private List<String> activityInfos;
        private ConfirmExt confirmExt;
        private SelectPromotion selectPromotion;
        private String toastMsg;
        private String greetingCard;
    }
    @lombok.Data
    public static class Addresses {
        private long id;
        private String receiverName;
        private String mobilePhone;
        private String province;
        private String city;
        private String area;
        private String detailAddress;
        private boolean hasDefault;
    }
    @lombok.Data
    public static class PayMethods {

        private String paymethodCode;
        private String paymethodDesc;
        private boolean chooseDefault;
        private String perInstallment;
    }
    @lombok.Data
    public static class CommodityPackages {

        private List<OrderCommodityUnits> orderCommodityUnits;
        private String packageIntro;
    }
    @lombok.Data
    public static class OrderCommodityUnits {

        private OrderCommodityVO orderCommodityVO;
        private List<Gifts> gifts;
        private int giftShowOpt;
        private List<String> serviceList;
        private List<String> bundledList;
        private int amount;
        private int promotionAmount;
        private String laserInfo;
        private String laserInfoV2;
        private int vscore;
    }
    @lombok.Data
    public static class OrderCommodityVO {

        private long commoditySpuId;
        private long commoditySkuId;
        private String commoditySkuCode;
        private String commodityName;
        private String commodityImgUrl;
        private int quantity;
        private int marketPrice;
        private int salePrice;
        private String color;
        private String actTag;
        private String actTagCode;
        private String qgActCode;
        private String isAtmosphere;
        private String qgPrice;
    }
    @lombok.Data
    public static class Gifts {

        private String giftSkuId;
        private String giftSpuId;
        private String giftCouponUuid;
        private String couponDesc;
        private String couponFlag;
        private String name;
        private String shortName;
        private String smallPic;
        private String bigPic;
        private String thumbnailPic;
        private String actCode;
        private String url;
        private String couponVoType;
        private String subAmount;
        private String couponRuleType;
        private int marketPrice;
        private int salePrice;
        private int giftFlag;
        private int giftType;
        private String shortDesc;
        private String giftSubType;
        private String vipGiftLevel;
        private int num;
        private String hourGiftPic;
        private String hourGiftEndTime;
        private String hourGiftStartTime;
        private String hourGiftOnTime;
        private String hourGiftFlag;
        private String id;
        private String optionalGiftId;
        private String canOptional;
        private String allOpCount;
        private int giveMethod;
    }
    @lombok.Data
    public static class SettleInfo {

        private int postFee;
        private int payAmount;
        private int actualPayAmount;
        private int commodityAmount;
        private int promotionAmount;
        private int worthPoint;
        private String tailReduceAmt;
        private String usedCoupon;
        private String usedVoucherCoupon;
        private int usablePoint;
        private int finalPayAmount;
        private int commodityTotalAmount;
        private int promotionTotalAmount;
        private int activityPromotion;
        private int commodityNum;
        private String shortDesc;
        private String pointPublicDesc;
    }
    @lombok.Data
    public static class UserOrderPromo {

        private List<String> usableCoupons;
        private List<String> voucherCoupons;
        private int cashCoupon;
        private UserPoint userPoint;
        private int point;
        private int usablePoint;
    }
    @lombok.Data
    public static class UserPoint {

        private int userPoint;
        private int usablePoint;
        private String shortDesc;
    }
    @lombok.Data
    public static class ConfirmExt {

        private String limitAddress;
        private String limitAddresses;
        private List<OrderCreateTips> orderCreateTips;
    }
    @lombok.Data
    public static class OrderCreateTips {

        private String tipType;
        private String tipProvince;
        private String tipCity;
        private String tipDistrict;
        private String tip;
    }
    @lombok.Data
    public static class SelectPromotion {

        private String activityUsed;
        private String payMethod;
        private String usedCouponNum;
        private String usedVoucherCouponNum;
        private int usedPoint;
        private int usedCashCoupon;
        private List<String> promoptionDetail;
    }

}