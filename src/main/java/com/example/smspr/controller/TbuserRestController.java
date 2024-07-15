package com.example.smspr.controller;

import com.example.smspr.domain.Tbuser;
import com.example.smspr.service.TbuserService;
import com.example.smspr.service.impl.TbuserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RequestMapping("/api/tbuser")
@RestController
public class TbuserRestController {

    private final TbuserService tbuserService;

    public TbuserRestController(TbuserService tbuserService)
    {
        this.tbuserService = tbuserService;
    }
    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params){
        return tbuserService.create(params);
    }

    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params){
        return tbuserService.update(params);
    }
    @GetMapping("/delete")
    public Map<String, Object> delete(String id){
        return tbuserService.delete(id);

    }

    @GetMapping("/detail")
    public Map<String, Object> detail(@RequestParam String id){
      return tbuserService.detail(id);
    }

    @GetMapping("/list")
    public Map<String, Object> list(){
       return tbuserService.list();
    }
}