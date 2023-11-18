package com.fish.replay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fish
 */
@MapperScan("com.fish.replay.mapper")
@SpringBootApplication
public class ReplayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReplayApplication.class, args);
	}

}
