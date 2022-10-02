package com.fish.mongodb.controller;

import com.fish.mongodb.dao.MongoTestDao;
import com.fish.mongodb.model.MongoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
 
/**
 * @author fish
 */
@RestController
public class MongoTestC {
 
    @Autowired
    private MongoTestDao mtdao;
 
    @GetMapping(value="/test1")
    public void saveTest() throws Exception {
        MongoTest mgtest=new MongoTest();
        mgtest.setId(3);
        mgtest.setAge(33);
        mgtest.setName("test");
        mtdao.saveTest(mgtest);
    }
 
    @GetMapping(value="/test2/{name}")
    public MongoTest findTestByName(@PathVariable String name){
        MongoTest mgtest= mtdao.findTestByName(name);
        System.out.println("mgtest is "+mgtest);
        return mgtest;
    }
 
    @GetMapping(value="/test3")
    public void updateTest(){
        MongoTest mgtest=new MongoTest();
        mgtest.setId(3);
        mgtest.setAge(44);
        mgtest.setName("hi");
        mtdao.updateTest(mgtest);
    }
 
    @GetMapping(value="/test4")
    public void deleteTestById(){
        mtdao.deleteTestById(1);
    }
}