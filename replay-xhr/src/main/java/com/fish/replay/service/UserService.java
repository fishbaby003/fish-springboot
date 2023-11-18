package com.fish.replay.service;

import com.fish.replay.entity.User;
import com.fish.replay.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author fish
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User sel(int id) {
        return userMapper.sel(id);
    }
    public List<User> getUserList() {
        userMapper.createTempTable(1);
        List<User> user=userMapper.getRepUserName();
        userMapper.dropTable();
        return user;
    }
}