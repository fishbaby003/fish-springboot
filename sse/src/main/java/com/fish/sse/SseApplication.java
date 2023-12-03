package com.fish.sse;

import cn.shuibo.annotation.EnableSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author fish
 */
@EnableScheduling
@EnableSecurity
@SpringBootApplication
public class SseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SseApplication.class, args);
	}

}
