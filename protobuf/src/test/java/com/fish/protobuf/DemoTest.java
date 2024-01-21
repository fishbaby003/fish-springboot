package com.fish.protobuf;

import com.fish.protobuf.entity.MessageUser;
import com.fish.protobuf.entity.MessageUserLogin;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

public class DemoTest {
    private WebClient webClient = WebClient.builder()
            .baseUrl("http://127.0.0.1:5013")
            .defaultHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko)")
            .defaultCookie("ACCESS_TOKEN", "test_token").build();

    @Test
    public void test() {
        try {
            MessageUser.MessageUserLogin.Builder builder =  MessageUser.MessageUserLogin.newBuilder();
            builder.setAccessToken(UUID.randomUUID().toString());
            builder.setUsername("test");
            try {
                Mono<MessageUser.MessageUserLogin> resp = webClient.method(HttpMethod.POST).uri("/post/test")
                        .contentType(MediaType.valueOf("application/x-protobuf"))
                        .bodyValue(builder.build().toByteArray())
                        .retrieve()
                        .bodyToMono(MessageUser.MessageUserLogin.class);
                MessageUser.MessageUserLogin data = resp.block();
                System.out.println("token----- " + data.getAccessToken());
                System.out.println("username----- " + data.getUsername());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {

        }
    }
}