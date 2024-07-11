package com.example.smspr.controller;

import com.example.smspr.domain.Tbuser;
import com.example.smspr.repository.TbuserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RequestMapping("/api/tbuser")
@RestController
public class TbuserRestController {

    private final TbuserRepository tbuserRepository;

    public TbuserRestController(TbuserRepository tbuserRepository){
        this.tbuserRepository = tbuserRepository;
    }
    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params){
        Map<String, Object> returnData = new HashMap<String, Object>();
        String resultCode;
        String resultData = "";
        String name = params.get("name") + "";
        String phone= params.get("phone") + "";
        String gender= params.get("gender") + "";
        String birth= params.get("birth") + "";


        if("".equals(name) || "null".equals(name)){
            resultCode = "이름을 입력하시오";
        } else if("".equals(phone) || "null".equals(phone)){
            resultCode = "핸드폰 번호를 입력하시오";
        } else if("".equals(gender) || "null".equals(gender)){
            resultCode = "성별을 입력하시오";
        }else if("".equals(birth) || "null".equals(birth)){
            resultCode = "생년월일을 입력하시오";
        }else {
            resultCode = "성공";
            Tbuser tbuser = Tbuser.getTbuser(name,phone,gender,birth);
            tbuserRepository.save(tbuser);
            resultData =tbuser.getId();
        }
        returnData.put("resultCode", resultCode);
        returnData.put("resultData", resultData);
        return returnData;
    }



    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params){
        Map<String, Object> returnData = new HashMap<String, Object>();
        String resultCode = "";
        String resultData = "";
        String id = params.get("id") + "";
        Tbuser tbuser = tbuserRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        String name = params.get("name") + "";
        String phone = params.get("phone") + "";
        String birth = params.get("birth") + "";
        String gender = params.get("gender") + "";

        System.out.println("params : " + params);

        if("".equals(name) || "null".equals(name)){
        } else {
            tbuser.setName(name);
            resultCode = "수정할 내용이 없습니다";
        }
        if("".equals(phone) || "null".equals(phone)){
        } else {
            tbuser.setPhone(phone);
            resultCode = "수정할 내용이 없습니다";
        }
        if("".equals(birth) || "null".equals(birth)){
        } else {
            tbuser.setBirth(birth);
            resultCode = "수정할 내용이 없습니다";
        }
        if("".equals(gender) || "null".equals(gender)){
        } else {
            tbuser.setGender(gender);
            resultCode = "수정할 내용이 없습니다";
        }
        tbuserRepository.save(tbuser);

        returnData.put("resultCode", resultCode);
        return returnData;
    }


    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params){
        Map<String, Object> returnData = new HashMap<String, Object>();
        String resultCode ="삭제에 성공했습니다";
        String resultData = "";
        String id = params.get("id") + "";
        Tbuser tbuser = tbuserRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        tbuserRepository.delete(tbuser);

        returnData.put("resultCode", resultCode);
        return returnData;
    }

    @GetMapping("/list")
    public Map<String, Object> list(){
        Map<String, Object> returnData = new LinkedHashMap<String, Object>();
        String resultCode ="리스트를 보여줍니다" ;
        returnData.put("resultCode", resultCode);
        returnData.put("resultData", tbuserRepository.findAll());
        return returnData;

    }
    @GetMapping("/detail")
    public Map<String, Object> detail(@RequestParam String id){
        Map<String, Object> returnData = new HashMap<String, Object>();
        int resultCode = 200;
        returnData.put("resultCode", resultCode);
        Tbuser tbuser = tbuserRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        returnData.put("resultData", tbuser);


        return returnData;
    }


}