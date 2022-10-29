package com.fish.logback;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class Springboot02MybatisApplicationTests {

  private final Logger logger = LoggerFactory.getLogger(Springboot02MybatisApplicationTests.class);
  @Test
  public void contextLoads() {
    logger.info("数据库日志info");
    logger.error("数据库日志error");
  }
}

