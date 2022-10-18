package com.fish.logback.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fish
 */
@RestController
public class LogController {
    private static Logger logger= LoggerFactory.getLogger("LogController");
    @GetMapping("/log")
    public String testLog(){
        logger.info("info");
        logger.debug("debug");
        logger.warn("warn");
        logger.error("error");
        return JSONObject.toJSONString(logger);
    }
}
