package com.fish.minio.controller;

import com.fish.minio.dto.Result;
import com.fish.minio.util.MinIoUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fish
 */
@RestController
@RequestMapping("/minio")
public class MinIoController {

    @Resource
    private MinIoUtils minIoUtils;


    /**
     * 存储桶名称
     */
    @Value("${buckets.name}")
    private String minioBucket;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result upload(@RequestParam(value = "files") MultipartFile files){
        try {
            return Result.ok(minIoUtils.upload(files,minioBucket,null));
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @GetMapping("/download")
    public void download(@RequestParam("minFileName")String minFileName,HttpServletResponse response){
            minIoUtils.download(response,minioBucket,minFileName);
    }
}