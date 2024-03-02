package com.fish.jpa.dao;

import com.fish.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 继承jpa
 * @author fish
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}