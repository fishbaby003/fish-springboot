package com.fish.rsa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author fish
 */
@Controller
public class IndexController {

    /**
     * http://localhost:5007/verify/bdczm?dzbh=DZ2023031701567
     * @param dzbh
     * @return
     */
    @GetMapping("/")
    public String ssx(String dzbh) {
        return "/index";
    }
   }
