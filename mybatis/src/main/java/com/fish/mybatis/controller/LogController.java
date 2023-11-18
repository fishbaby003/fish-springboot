package com.fish.mybatis.controller;

import com.fish.mybatis.entity.Log;
import com.fish.mybatis.service.LogService;
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
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService LogService;

    /**
     * query Log by id
     * @param id
     * @return
     */
    @RequestMapping("getById/{id}")
    public Log getById(@PathVariable int id) {
        return LogService.getById(id);
    }

    /**
     * query all Log
     * @return
     */
    @RequestMapping("getByAll")
    public String getByAll() {
        return LogService.getByAll();
    }

    /**
     * query Log by page
     * @param currPage
     * @param pageSize
     * @return
     */
    @GetMapping("getByPage/{currPage}/{pageSize}")
    public List<Log> getByPage(@PathVariable int currPage,@PathVariable int pageSize) {
        return LogService.queryLogsBySql(currPage,pageSize);
    }
}