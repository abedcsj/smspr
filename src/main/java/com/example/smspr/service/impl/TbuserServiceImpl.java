package com.example.smspr.service.impl;

import com.example.smspr.domain.Tbuser;
import com.example.smspr.repository.TbuserRepository;
import com.example.smspr.service.TbuserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@Service
public class TbuserServiceImpl implements TbuserService {

    private final TbuserRepository tbuserRepository;

    public TbuserServiceImpl(TbuserRepository tbuserRepository){
        this.tbuserRepository = tbuserRepository;
    }


    public Map<String,Object> create(Map<String,Object> params){
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


    };
    public Map<String, Object> update(Map<String, Object> param){
        return null;
    };
    public Map<String, Object> delete(String id){
        return null;
    };
    public Map<String, Object> detail(String id){
        return null;
    };
    public Map<String, Object> list(){
        Map<String, Object> returnData = new LinkedHashMap<String, Object>();
        String resultCode ="리스트를 보여줍니다" ;
        returnData.put("resultCode", resultCode);
        returnData.put("resultData", tbuserRepository.findAll());
        return returnData;
    };
}
