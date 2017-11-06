package com.vinsen.controller.admin;

import com.vinsen.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangshengwen
 */
@Controller
public class HomeCtr {

    private static final String ADMIN_UNAME = "admin";

    private static final String ADMIN_PWD = "admin";

    @GetMapping("/")
    public String toLogin() {
        return "login";
    }


    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/doLogin")
    @ResponseBody
    public String login(User user) {
        if (ADMIN_UNAME.equals(user.getUname()) && ADMIN_PWD.equals(user.getPwd())) {
            return "success";
        } else {
            return "failed";
        }
    }
}
