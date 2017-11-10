package com.vinsen.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author zhangshengwen
 * @date 2017/11/8
 */
@Controller
public class IndexCtr {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
