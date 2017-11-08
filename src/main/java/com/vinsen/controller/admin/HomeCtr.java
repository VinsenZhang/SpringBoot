package com.vinsen.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台页面的路由
 * @author zhangshengwen
 */
@Controller
@RequestMapping("/admin")
public class HomeCtr {

    @GetMapping("/")
    public String toLogin() {
        return "admin/login";
    }


    @GetMapping("/index")
    public String index() {
        return "admin/index";
    }


}
