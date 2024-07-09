package com.example.smspr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DefaultPageController {

    @GetMapping("/index")
    public String index(@RequestParam int test1, @RequestParam int test2) {
        return "haha";
    }



}
