package com.fish.rsa.controller;

import cn.shuibo.annotation.Decrypt;
import cn.shuibo.annotation.Encrypt;
import com.fish.rsa.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author fish
 */
@RestController
@RequestMapping("/user")
public class UserController {

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
    @ResponseBody
    @PostMapping("/decryption")
    public String Decryption(@RequestBody User user){
        return user.toString();
    }
    @Decrypt
    @GetMapping("/getData")
    public String getData(User user){
        return user.toString();
    }
}