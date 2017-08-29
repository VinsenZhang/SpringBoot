package com.vinsen.controller.api;

import com.vinsen.bean.User;
import com.vinsen.dao.UserDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "User", description = "user apis")
@RestController
@RequestMapping("/user")
public class UserCtr {

    @Autowired
    UserDao userDao;



    @ApiOperation(value = "/{uid}", notes = "test test", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping("/{uid}")
    public String getUserInfo(@PathVariable int uid){
        User user = userDao.get(uid);
        return user.toString();
    }


}
