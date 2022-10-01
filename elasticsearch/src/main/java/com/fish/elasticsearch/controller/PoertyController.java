package com.fish.elasticsearch.controller;

import com.fish.elasticsearch.entity.Poetry;
import com.fish.elasticsearch.entity.EsPoetry;
import com.fish.elasticsearch.service.PoetryService;
import com.fish.elasticsearch.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author fish
 * 2022/10/01
 */
@RestController
public class PoertyController {
    @Autowired
    private PoetryService poetryService;

    /**
     * 添加古诗
     *
     * @param poetry
     * @return
     */
    @PostMapping("/addPoetry")
    public Result addPoetry(@RequestBody Poetry poetry) {
        poetryService.addPoetry(poetry);
        return Result.succeed(poetry, "操作成功");
    }

    /**
     * 根据关键词查询古诗
     *
     * @param key
     * @return
     */
    @GetMapping("/poetry/search")
    public SearchHits<EsPoetry> search(String key) {
        return poetryService.searchPoetry1(key);
    }

    /**
     * 根据关键词查询古诗（JPA查询）
     *
     * @param key
     * @return
     */
    @GetMapping("/poetry/search/es")
    public List<EsPoetry> searchEs(String key) {
        return poetryService.searchPoetry(key);
    }

    /**
     * 根据关键字查询mysql古诗表
     *
     * @param key
     * @return
     */
    @GetMapping("/poetry/searchByMysql")
    public List<Poetry> searchByMysql(String key) {
        return poetryService.searchPoetryFromMysql(key);
    }


    /**
     * 删除古诗
     *
     * @param poetry
     * @return
     */
    @PostMapping("/deletePoetry")
    public Result deletePoetry(@RequestBody Poetry poetry) {
        poetryService.deletePoetry(poetry.getId());
        return Result.succeed("操作成功");
    }

    /**
     * es分页查询古诗
     * @param current
     * @param rowCount
     * @param title
     * @param author
     * @return
     */
    @GetMapping("/poetry/getEsPoetryByPage")
    public Map<String, Object> getEsPoetryByPage(@RequestParam(value="current") int current, @RequestParam(value="rowCount") int rowCount
            , @RequestParam(value="title",required=false) String title
            , @RequestParam(value="author",required=false) String author) {
        return poetryService.getEsPoetryByPage(current,rowCount,title, author);
    }
}