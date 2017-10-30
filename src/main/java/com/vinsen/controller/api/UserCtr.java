package com.vinsen.controller.api;

import com.vinsen.bean.User;
import com.vinsen.dao.UserDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api(value = "User", description = "user apis")
@RestController
@RequestMapping("/user")
public class UserCtr {

    @Autowired
    private UserDao userDao;

    @ApiOperation(value = "/{uid}", notes = "test test", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping("/{uid}")
    public String getUserInfo(@PathVariable int uid) {

        User user = userDao.getUserById(uid);
        return user.toString();
    }

    @ApiOperation(value = "/add", notes = "add user", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("/add")
    public String insertUser(@RequestBody User user) {
        try {
            userDao.insert(user);
            return "OK";
        } catch (Exception e) {
            return e.getMessage();
        }
    }


}
