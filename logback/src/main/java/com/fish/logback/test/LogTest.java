package com.fish.logback.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fish
 */
public class LogTest {
    private static Logger logger=LoggerFactory.getLogger("LogTest");

    public static void main(String[] args) {
        System.out.println(000000);
        logger.info("info");
        logger.debug("debug");
        logger.warn("warn");
        logger.error("error");
        System.out.println(111111);
    }
}
