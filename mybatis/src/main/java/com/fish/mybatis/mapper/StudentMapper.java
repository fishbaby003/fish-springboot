package com.fish.mybatis.mapper;

import com.fish.mybatis.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author fish
 */
@Repository
public interface StudentMapper {
    /**
     * query student by id
     * @param id
     * @return
     */
    Student getById(int id);

    /**
     * query all student by list
     * @return
     */
    List<Student> getByAll();

    /**
     * query student by page
     * @param data
     * @return
     */
    List<Student> queryStudentsBySql(Map<String,Object> data);
}