package com.fish.feign.controller;

import cn.shuibo.annotation.Decrypt;
import cn.shuibo.annotation.Encrypt;
import com.fish.feign.entity.User;
import com.fish.feign.service.UserService;
import com.fish.feign.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author fish
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("hello")
    public String sayHello() {
        return userService.sayHello();
    }

    @PostMapping("/save")
    public Result save(@Valid @RequestBody User user) {
        return Result.ok(user);
    }

    @Encrypt
    @GetMapping("/encryption")
    public User encryption(){
        User user = new User();
        user.setName("fish");
        user.setAge(18);
        user.setAddr("addr");
        return user;
    }



    @Encrypt
    @PostMapping("/postEncryption")
    public User postEncryption(@RequestBody User user){
        return user;
    }

    @Decrypt
    @PostMapping("/decryption")
    public String Decryption(@RequestBody User user){
        return user.toString();
    }
}