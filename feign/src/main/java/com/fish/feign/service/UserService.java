package com.fish.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author fish
 */
@FeignClient(name = "userService",url = "http://localhost:5004")
public interface UserService {

    /**
     * 远程调用hello接口
     * @return
     */
    @GetMapping("/hello")
    String sayHello();
}