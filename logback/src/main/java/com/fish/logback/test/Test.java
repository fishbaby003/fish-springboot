package com.fish.logback.test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import java.text.SimpleDateFormat;
import java.util.Date;
 
/**
 * @author fish
 */
public class Test {
 
    public static void main(String[] args) {
        
        Logger logger = LoggerFactory.getLogger(Test.class);
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
        logger.debug(simpleDateFormat.format(new Date()) + "将日志写入数据库");
        logger.info(simpleDateFormat.format(new Date()) + "将info日志写入数据库");
        logger.error(simpleDateFormat.format(new Date()) + "将error日志写入数据库");

    }
}