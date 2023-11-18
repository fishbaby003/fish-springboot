package com.fish.mybatis.entity;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author fish
 */
@Data
public class Log {
    private String requestId;
    private String apiGroupId;
    private String apiGroupName;
    private String apiId;
    private String apiName;
    private String apiStageId;
    private String apiStageName;
    private String httpMethod;
    private String path;
    private String domain;
    private String statusCode;
    private String projectId;
    private String appName;
    private String clientIp;
    private String providerAliId;
    private String region;
    private BigInteger serviceLatency;
    private String requestProtocol;
    private Timestamp requestHandleTime;
}
