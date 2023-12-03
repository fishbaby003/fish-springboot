package com.fish.sse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author fish
 */
@Controller
public class IndexController {

    /**
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "/index";
    }
   }
