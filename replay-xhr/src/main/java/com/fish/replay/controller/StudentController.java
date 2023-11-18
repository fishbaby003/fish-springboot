package com.fish.replay.controller;

import com.fish.replay.entity.Student;
import com.fish.replay.service.StudentService;
import online.inote.naruto.anti.replay.annotation.NarutoAntiReplay;
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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * query student by id
     * @param id
     * @return
     */
    @GetMapping("getById/{id}")
    public Student getById(@PathVariable int id) {
        return studentService.getById(id);
    }

    /**
     * query all student
     * @return
     */
    @NarutoAntiReplay
    @GetMapping("getByAll")
    public List<Student> getByAll() {
        return studentService.getByAll();
    }

    /**
     * query student by page
     * @param currPage
     * @param pageSize
     * @return
     */
    @GetMapping("getByPage/{currPage}/{pageSize}")
    public List<Student> getByPage(@PathVariable int currPage,@PathVariable int pageSize) {
        return studentService.queryStudentsBySql(currPage,pageSize);
    }
}