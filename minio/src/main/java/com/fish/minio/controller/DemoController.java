package com.fish.minio.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fish
 */
@Api(tags = "测试模块")
@RestController
public class DemoController {
    @ApiImplicitParam(name = "name", value = "姓名", required = true)
    @ApiOperation(value = "入门程序，Hello World")
    @PostMapping("/helloWorld")
    public ResponseEntity<String> helloWorld(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok("Hello World，" + name);
    }
}
