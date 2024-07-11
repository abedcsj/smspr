package com.example.smspr.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tbuser")
@Controller
public class TbuserPageController {

    @GetMapping("")
    public String empty(){
        return "index";
    }
    @GetMapping("/index")
    public String index(){
        return "tbuser/index";
    }
    //2024-07-10
    @GetMapping("/{page}")
    public String page(@PathVariable("page") String page){
        return "tbuser/" + page;
    }
    //2024-07-11
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id){
        return "tbuser/detail";
    }

}