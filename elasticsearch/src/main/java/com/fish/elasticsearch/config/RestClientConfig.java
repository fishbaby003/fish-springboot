//package com.fish.elasticsearch.config;
//
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.client.ClientConfiguration;
//import org.springframework.data.elasticsearch.client.RestClients;
//import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
//
///**
// * ElasticSearch 客户端配置
// *
// * @author fish
// * 2022/09/09
// */
//@Configuration
//public class RestClientConfig extends AbstractElasticsearchConfiguration {
//    private String userName = "elastic";
//    private String password = "123456";
//    @Value("${spring.elasticsearch.rest.uris}")
//    private String ipAddress;
//
//    @Override
//    @Bean
//    public RestHighLevelClient elasticsearchClient() {
//        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo("192.168.80.132:9200")
//                .withBasicAuth(userName, password)
//                .build();
//        return RestClients.create(clientConfiguration).rest();
//    }
//}