package com.vinsen.controller.admin.api;

import com.vinsen.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * 管理后台用户
 * @author zhangshengwen
 * @date 2017/11/8
 */
@RestController
public class AdminCtr {

    private static final String ADMIN_UNAME = "admin";

    private static final String ADMIN_PWD = "admin";

    @PostMapping("/doLogin")
    public String login(HttpServletRequest request, User user) {
        if (ADMIN_UNAME.equals(user.getNickname()) && ADMIN_PWD.equals(user.getIp())) {
            request.getSession().setAttribute("currentUser", user);
            return "success";
        } else {
            return "failed";
        }
    }
}
