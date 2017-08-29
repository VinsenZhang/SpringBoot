package com.vinsen.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeCtr {

    @GetMapping("/")
    public String login(){
        return "login";
    }


    @GetMapping("/index")
    public String index() {
        return "index";
    }

}
