package com.fish.protobuf;

import com.fish.protobuf.entity.MessageUser;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

public class DemoApplicationTests {
    private WebClient webClient = WebClient.builder()
            .baseUrl("http://127.0.0.1:5013")
            .defaultHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko)")
            .defaultCookie("ACCESS_TOKEN", "test_token").build();

    @Test
    public void test() {
        try {
            URI uri = new URI("http", null, "127.0.0.1", 5013, "/demo/test", "", null);
            try {
                Mono<MessageUser.MessageUserLogin> resp = webClient.method(HttpMethod.GET).uri("test")
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