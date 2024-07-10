package com.example.smspr.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("") //무조건 선언해야함
@Controller
public class DefaultPageController {

    //2024-07-09
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    //아무것도 안 입력했을 때도 index로 가게함
    @GetMapping({"","/"})
    public String empty(){
        //return "index";
        ///index로 바꿔줌
        return "redirect:/index";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
    //2024-07-10
    @GetMapping("/page1")
    public String page1(){
        return "page1";
    }


}