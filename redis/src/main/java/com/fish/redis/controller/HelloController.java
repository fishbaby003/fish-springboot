package com.fish.redis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author fish
 */
@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello() {
        return "hello,tom!";
    }

    @GetMapping("test")
    public void testRed(HttpServletResponse response) throws Exception {
        response.sendRedirect("/hello");
    }

}
