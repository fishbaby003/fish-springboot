package com.fish.feign.controller;

import com.fish.feign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fish
 */
@RestController
public class UserController{
    @Autowired
    private UserService userService;

    @GetMapping("hello")
    public String sayHello(){
        return userService.sayHello();
    }

}