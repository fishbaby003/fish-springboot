package com.fish.jpa.controller;

import com.fish.jpa.dao.UserRepository;
import com.fish.jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * 用户控制层
 * @author fish
 */
@RestController
public class UserController {
    @Autowired
    UserRepository userMapper;
 
    /**
     * 获取所有用户
     */
    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users = userMapper.findAll();
        return users;
    }
 
    /**
     * 根据id获取用户信息
     * @param id
     */
    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable("id") Integer id){
        Optional<User> user = userMapper.findById(id);
        return user;
    }
}