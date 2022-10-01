package com.fish.minio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author fish
 */
@EnableWebMvc
@SpringBootApplication
public class MinioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinioApplication.class, args);
	}

}
