package com.vinsen.dao;

import com.vinsen.bean.User;
import org.apache.ibatis.annotations.*;

import java.io.Serializable;

@Mapper
public interface UserDao extends BaseDao<User> {


    @Select("SELECT * FROM user where uid = #{id}")
    @Results({
            @Result(property = "uid", column = "uid"),
            @Result(property = "uname", column = "uname"),
            @Result(property = "pwd", column = "pwd")
    })
    @Override
    User get(Serializable id);


    @Insert("insert into user(uname,pwd) values(#{uname},#{pwd})")
    @Override
    void insert(User entity);


}
