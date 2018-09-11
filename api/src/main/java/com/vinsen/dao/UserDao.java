package com.vinsen.dao;

import com.vinsen.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangshengwen
 */
@Component
public interface UserDao{


    /**
     * 查询用户
     */
    User getUserById(int id);


    /**
     * 查询所有用户
     */
    List<User> getAllUser();


    /**
     * 插入用户
     */
    void insert(User entity);


}
