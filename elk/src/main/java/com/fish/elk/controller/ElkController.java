package com.fish.elk.controller;

import com.fish.elk.domain.User;
import com.fish.elk.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


/**
 * @Description:
 * @Author: fish
 * @Date: 2023/11/19 17:17
 */
@RestController
@Api(tags = "ELKController", description = "ELK日志搭建案例")
@RequestMapping(value = "/elk")
public class ElkController {

    @GetMapping(value = "/test")
    @ApiOperation(value = "elk日志测试控制层方法")
    public Result elk(@RequestParam String elk) {

        return Result.ok(elk);
    }


    @GetMapping(value = "/path")
    @ApiOperation(value = "elk日志测试控制层方法")
    public Result path(@RequestBody String name, @RequestParam String value) {

        return Result.ok(name+value);
    }

    @GetMapping(value = "/validation")
    @ApiOperation(value = "elk日志测试控制层方法")
    public Result validation(@RequestBody User user) {
        return Result.ok(user);
    }

    @GetMapping(value = "/an")
    @ApiOperation(value = "elk日志测试控制层方法")
    public Result an() {
        return Result.ok("ok");
    }

    @GetMapping(value = "/branchTest")
    @ApiOperation(value = "分支测试")
    public Result branchTest() {
        return Result.ok("ok");
    }

    @PostMapping(value = "/branchTest2")
    @ApiOperation(value = "分支测试2")
    public Result branchTest2() {
        return Result.ok("ok");
    }

    @PostMapping(value = "/branchTest3")
    @ApiOperation(value = "分支测试3")
    public Result branchTest3() {
        return Result.ok("ok");
    }


}
