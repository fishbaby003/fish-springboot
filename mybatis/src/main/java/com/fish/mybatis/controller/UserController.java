package com.fish.mybatis.controller;

import com.fish.mybatis.entity.User;
import com.fish.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fish
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * query user by id
     * @param id
     * @return
     */
    @RequestMapping("getUser/{id}")
    public User getUser(@PathVariable int id) {
        return userService.sel(id);
    }

    /**
     * query user by list
     * @return
     */
    @RequestMapping("getUserList")
    public List<User> getUserList() {
        return userService.getUserList();
    }
}