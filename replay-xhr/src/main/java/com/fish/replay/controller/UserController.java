package com.fish.replay.controller;

import com.fish.replay.entity.User;
import com.fish.replay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("getUser/{id}")
    public User getUser(@PathVariable int id) {
        return userService.sel(id);
    }

    /**
     * query user by list
     * @return
     */
    @GetMapping("getUserList")
    public List<User> getUserList() {
        return userService.getUserList();
    }
}