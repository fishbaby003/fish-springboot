package com.fish.replay.service;

import com.fish.replay.entity.Student;
import com.fish.replay.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fish
 */
@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public Student getById(int id) {
        return studentMapper.getById(id);
    }
    public List<Student> getByAll() {
        List<Student> studentList=studentMapper.getByAll();
        return studentList;
    }
    public List<Student> queryStudentsBySql(int currPage, int pageSize) {
        Map<String, Object> data = new HashMap();
        data.put("currIndex", (currPage-1)*pageSize);
        data.put("pageSize", pageSize);
        return studentMapper.queryStudentsBySql(data);
    }
}