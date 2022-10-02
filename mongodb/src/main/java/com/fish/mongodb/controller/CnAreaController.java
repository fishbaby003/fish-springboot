package com.fish.mongodb.controller;

import cn.hutool.json.JSONUtil;
import com.fish.mongodb.dao.CnAreaDao;
import com.fish.mongodb.model.CnArea;
import com.fish.mongodb.util.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 中国行政地区
 *
 * @author fish
 */
@Slf4j
@RestController
public class CnAreaController {

    @Autowired
    private CnAreaDao cnAreaDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 新增中国行政地区
     *
     * @param cnArea
     */
    @PostMapping(value = "/addArea")
    public AjaxResult addArea(@RequestBody CnArea cnArea) {
        cnAreaDao.save(cnArea);
        log.info("【cnArea】= {}", JSONUtil.toJsonStr(cnArea));
        return AjaxResult.success(cnArea);
    }

    /**
     * 批量新增中国行政地区
     */
    @PostMapping(value = "/addAreaList")
    public AjaxResult addAreaList(@RequestBody List<CnArea> cnAreaList) {
        cnAreaDao.saveAll(cnAreaList);
        log.info("【articles】= {}", JSONUtil.toJsonStr(cnAreaList.stream().map(CnArea::getId).collect(Collectors.toList())));
        return AjaxResult.success(cnAreaList);
    }

    /**
     * 更新中国行政地区
     */
    @PostMapping(value = "/updateArea")
    public AjaxResult updateArea(@RequestBody CnArea cnArea) {
        cnAreaDao.findById(Long.valueOf(cnArea.getId())).ifPresent(area -> {
            area.setName(cnArea.getName());
            area.setShortName(cnArea.getShortName());
            cnAreaDao.save(area);
            log.info("【article】= {}", JSONUtil.toJsonStr(area));
        });
        return AjaxResult.success();
    }

    /**
     * 更新中国行政地区第二种方法
     */
    @PostMapping(value = "/updateArea2")
    public AjaxResult updateArea2(@RequestBody CnArea cnArea) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(1L));
        Update update = new Update();
        update.set("name", cnArea.getName());
        update.inc("level", cnArea.getLevel());
        mongoTemplate.updateFirst(query, update, "cn_area");

        cnAreaDao.findById(1L).ifPresent(area -> log.info("【名称】= {}【level】= {}【简称】= {}", area.getName(), area.getLevel(), area.getShortName()));
        return AjaxResult.success();
    }

    /**
     * 分页查询中国行政地区
     */
    @GetMapping(value = "/getByPage")
    public AjaxResult getByPage() {
        Sort sort = Sort.by("city_code", "name").descending();
        PageRequest pageRequest = PageRequest.of(0, 5, sort);
        Page<CnArea> all = cnAreaDao.findAll(pageRequest);
        log.info("【总页数】= {}", all.getTotalPages());
        log.info("【总条数】= {}", all.getTotalElements());
        log.info("【当前页数据】= {}", JSONUtil.toJsonStr(all.getContent().stream().map(article -> "区号：" + article.getLevel() + "名称：" + article.getName() + "简称：" + article.getShortName()).collect(Collectors.toList())));
        return AjaxResult.success(all);
    }

    /**
     * 根据name模糊查询
     */
    @GetMapping(value = "/getByNameLike")
    public AjaxResult getByNameLike(@RequestParam(value = "name") String name) {
        List<CnArea> areas = cnAreaDao.findByNameLike(name);
        log.info("【areas】= {}", JSONUtil.toJsonStr(areas));
        return AjaxResult.success(areas);
    }

    /**
     * 删除中国行政地区
     */
    @GetMapping(value = "/deleteArea")
    public void deleteAreaById(@RequestParam("id") Long id) {
        // 根据主键删除
        cnAreaDao.deleteById(id);
    }

    /**
     * 删除全部中国行政地区
     */
    @GetMapping(value = "/deleteAll")
    public void deleteAll() {
        // 全部删除
        cnAreaDao.deleteAll();
    }
}