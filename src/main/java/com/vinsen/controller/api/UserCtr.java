package com.vinsen.controller.api;

import com.vinsen.http.message.Message;
import com.vinsen.http.message.SucccessMessage;
import com.vinsen.model.User;
import com.vinsen.dao.UserDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhangshengwen
 */
@Api(value = "User", description = "user apis")
@RestController
@RequestMapping("/api/user")
public class UserCtr {

    @Autowired
    private UserDao userDao;

    @ApiOperation(value = "/{uid}", notes = "test test", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping("/{uid}")
    public Message getUser(@PathVariable int uid) {
        return new SucccessMessage(userDao.getUserById(uid));
    }

    @ApiOperation(value = "/add", notes = "add user", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("/add")
    public Message insertUser(@RequestBody User user) {
        userDao.insert(user);
        return new SucccessMessage();
    }

    @ApiOperation(value = "/get-all", notes = "get all user", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping("/get-all")
    public Message getAllUser() {
        return new SucccessMessage(userDao.getAllUser());
    }

}
