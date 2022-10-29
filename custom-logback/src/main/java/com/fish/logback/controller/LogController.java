package com.fish.logback.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fish
 */
@RestController
public class LogController {
    private static Logger logger= LoggerFactory.getLogger(LogController.class);
    @GetMapping("/log")
    public String testLog(@RequestParam("str") String str){
        logger.info("info");
        logger.debug("debug");
        logger.warn("warn");
//        logger.error("error");
        logger.error("- 异常："+str);
        return JSONObject.toJSONString(logger);
    }
}
