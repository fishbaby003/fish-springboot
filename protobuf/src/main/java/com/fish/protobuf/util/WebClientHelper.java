package com.fish.protobuf.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 网络请求工具类
 *
 * @author admin
 */
public class WebClientHelper {

    private static final Integer DEFAULT_CONNECT_TIMEOUT = 3000;

    private static final Integer DEFAULT_REQUEST_TIMEOUT = 10000;

    /**
     * get请求解析成字符串
     *
     * @param url url
     * @return java.lang.String
     * @author admin admin
     * @since 2019/10/30
     */
    public static ClientResponse getResponse(String url) {
        Mono<ClientResponse> resp = createWebClientWithConnectAndReadTimeOuts()
                .get()
                .uri(url)
                .exchange();

        return resp.block();
    }

    /**
     * get请求，解析成对象
     *
     * @param url     url
     * @param tClass  class
     * @param headers 请求头
     * @return T
     * @author admin
     * @since 2019/10/30
     */
    public static <T> T get(String url, Class<T> tClass, Map<String, String> headers) {
        Mono<T> resp = createWebClientWithConnectAndReadTimeOuts()
                .get()
                .uri(url)
                .headers(t -> t.setAll(headers))
                .retrieve()
                .bodyToMono(tClass).timeout(Duration.ofMillis(DEFAULT_REQUEST_TIMEOUT));
        return resp.block();
    }

    /**
     * get请求，解析成对象
     *
     * @param url     url
     * @param headers 请求头
     * @return T
     * @author admin
     * @since 2019/10/30
     */
    public static String get(String url, Map<String, String> headers) {
        Mono<String> resp = createWebClientWithConnectAndReadTimeOuts()
                .get()
                .uri(url)
                .headers(t -> t.setAll(headers))
                .retrieve()
                .bodyToMono(String.class).timeout(Duration.ofMillis(DEFAULT_REQUEST_TIMEOUT));
        return resp.block();
    }

    /**
     * get请求，解析成对象
     *
     * @param scheme  协议 http/https
     * @param host    host
     * @param obj     query params
     * @param headers 请求头
     * @return T
     * @author admin
     * @since 2019/10/30
     */
    public static String get(String scheme, String host, String path, Object obj, Map<String, String> headers) {
        Mono<String> resp = createWebClientWithConnectAndReadTimeOuts()
                .get()
                .uri(uriBuilder -> uriBuilder.scheme(scheme).host(host).path(path).queryParams(getRequestParamMapByObj(obj)).build())
                .headers(t -> t.setAll(headers))
                .retrieve()
                .bodyToMono(String.class).timeout(Duration.ofMillis(DEFAULT_REQUEST_TIMEOUT));
        return resp.block();
    }

    /**
     * get请求，解析成对象
     *
     * @param url    url
     * @param tClass class
     * @return T
     * @author admin
     * @since 2019/10/30
     */
    public static <T> T get(String url, Object obj, Class<T> tClass) {
        Mono<T> resp = createWebClientWithConnectAndReadTimeOuts()
                .get()
                .uri(uriBuilder -> uriBuilder.path(url).queryParams(getRequestParamMapByObj(obj)).build())
                .retrieve()
                .bodyToMono(tClass).timeout(Duration.ofMillis(DEFAULT_REQUEST_TIMEOUT));
        return resp.block();
    }


    /**
     * get请求，解析成对象
     *
     * @param url    url
     * @param tClass class
     * @return T
     * @author admin
     * @since 2019/10/30
     */
    public static <T> T get(String url, Class<T> tClass) {
        Mono<T> resp = createWebClientWithConnectAndReadTimeOuts()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(tClass).timeout(Duration.ofMillis(DEFAULT_REQUEST_TIMEOUT));
        return resp.block();
    }

    /**
     * get请求解析成字符串
     *
     * @param url url
     * @return java.lang.String
     * @author admin
     * @since 2019/10/30
     */
    public static String get(String url) {
        Mono<String> resp = createWebClientWithConnectAndReadTimeOuts()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class).timeout(Duration.ofMillis(DEFAULT_REQUEST_TIMEOUT));

        return resp.block();
    }

    /**
     * post表单请求返回对象
     *
     * @param url    url
     * @param params 请求参数
     * @param tClass 返回对象
     * @return T
     * @author admin
     * @since 2019/10/30
     */
    public static <T> T post(String url, Map<String, String> params, Class<T> tClass) {
        MultiValueMap<String, String> formData = getRequestParamMap(params);
        Mono<T> resp = createWebClientWithConnectAndReadTimeOuts().post()
                .uri(url)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(formData))
                .retrieve().bodyToMono(tClass).timeout(Duration.ofMillis(DEFAULT_REQUEST_TIMEOUT));

        return resp.block();
    }

    /**
     * post表单请求返回字符串
     *
     * @param url    url
     * @param params 请求参数
     * @return java.lang.String
     * @author admin
     * @since 2019/10/30
     */
    public static String post(String url, Map<String, String> params) {
        MultiValueMap<String, String> formData = getRequestParamMap(params);
        Mono<String> resp = createWebClientWithConnectAndReadTimeOuts().post()
                .uri(url)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(formData))
                .retrieve().bodyToMono(String.class).timeout(Duration.ofMillis(DEFAULT_REQUEST_TIMEOUT));

        return resp.block();
    }

    /**
     * post json请求结果解析成对象
     *
     * @param url      url
     * @param jsonBody 请求body，可以是对象或者是map
     * @param tClass   解析对象
     * @return T
     * @author admin
     * @since 2019/10/30
     */
    public static <T> T postJson(String url, Object jsonBody, Class<T> tClass) {
        Mono<T> resp = createWebClientWithConnectAndReadTimeOuts().post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(jsonBody), Object.class)
                .retrieve().bodyToMono(tClass).timeout(Duration.ofMillis(DEFAULT_REQUEST_TIMEOUT));

        return resp.block();
    }

    /**
     * post json请求结果解析成对象
     *
     * @param url      url
     * @param jsonBody 请求body，可以是对象或者是map
     * @param tClass   解析对象
     * @return T
     * @author admin
     * @since 2019/10/30
     */
    public static <T> T postJson(String url, Map<String, String> headers, Object jsonBody, Class<T> tClass) {
        Mono<T> resp = createWebClientWithConnectAndReadTimeOuts().post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .headers(t -> t.setAll(headers))
                .body(Mono.just(jsonBody), Object.class)
                .retrieve().bodyToMono(tClass).timeout(Duration.ofMillis(DEFAULT_REQUEST_TIMEOUT));

        return resp.block();
    }

    /**
     * post json请求结果解析成字符串
     *
     * @param url      url
     * @param jsonBody 请求body，可以是对象或者是map
     * @return java.lang.String
     * @author admin
     * @since 2019/10/30
     */
    public static String postJson(String url, Object jsonBody) {
        Mono<String> resp = createWebClientWithConnectAndReadTimeOuts().post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(jsonBody), Object.class)
                .retrieve().bodyToMono(String.class).timeout(Duration.ofMillis(DEFAULT_REQUEST_TIMEOUT));

        return resp.block();
    }

    /**
     * post json请求结果解析成字符串
     *
     * @param url      url
     * @param jsonBody 请求body，可以是对象或者是map
     * @return java.lang.String
     * @author admin
     * @since 2019/10/30
     */
    public static String postJson(String url, Map<String, String> headers, Object jsonBody) {
        Mono<String> resp = createWebClientWithConnectAndReadTimeOuts().post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .headers(t -> t.setAll(headers))
                .body(Mono.just(jsonBody), Object.class)
                .retrieve().bodyToMono(String.class).timeout(Duration.ofMillis(DEFAULT_REQUEST_TIMEOUT));

        return resp.block();
    }

    public static <T> T postRawJson(String url, String jsonBody, Class<T> tClass) {
        Mono<T> resp = createWebClientWithConnectAndReadTimeOuts().post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(jsonBody))
                .retrieve().bodyToMono(tClass).timeout(Duration.ofMillis(DEFAULT_REQUEST_TIMEOUT));

        return resp.block();
    }

    public static String postRawJson(String url, String jsonBody) {
        Mono<String> resp = createWebClientWithConnectAndReadTimeOuts().post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(jsonBody))
                .retrieve().bodyToMono(String.class).timeout(Duration.ofMillis(DEFAULT_REQUEST_TIMEOUT));

        return resp.block();
    }

    private static WebClient createWebClientWithConnectAndReadTimeOuts() {
        // create reactor netty HTTP client
        HttpClient httpClient = HttpClient.create()
                .tcpConfiguration(tcpClient -> {
                    tcpClient = tcpClient.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, DEFAULT_CONNECT_TIMEOUT);
                    tcpClient = tcpClient.doOnConnected(conn -> conn
                            .addHandlerLast(new ReadTimeoutHandler(DEFAULT_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)));
                    return tcpClient;
                });
        // create a client http connector using above http client
        ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);
        // use this configured http connector to build the web client
        return WebClient.builder().clientConnector(connector).build();
    }

    private static MultiValueMap<String, String> getRequestParamMap(Map<String, String> params) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            queryParams.add(entry.getKey(), entry.getValue());
        }

        return queryParams;
    }

    private static MultiValueMap<String, String> getRequestParamMapByObj(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.convertValue(obj, new TypeReference<Map<String, Object>>() {
        });
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (Objects.isNull(entry.getValue())) {
                continue;
            }
            queryParams.add(entry.getKey(), String.valueOf(entry.getValue()));
        }

        return queryParams;
    }


}