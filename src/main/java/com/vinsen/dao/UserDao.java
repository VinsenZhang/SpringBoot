package com.vinsen.dao;

import com.vinsen.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author zhangshengwen
 */
@Component
public interface UserDao{


    /**
     * 查询用户
     * @param id
     * @return
     */
    User getUserById(int id);


    /**
     * 插入用户
     * @param entity
     */
    void insert(User entity);


}
