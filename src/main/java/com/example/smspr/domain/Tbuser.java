package com.example.smspr.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Table
@Entity
public class Tbuser {

    @Id
    private String id;
    @Setter@Column private String name;
    @Setter@Column private String phone;
    @Setter@Column private String gender;
    @Setter@Column private String birth;

    public Tbuser(){


    }

    private Tbuser(String id, String name, String phone, String gender, String birth) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.birth = birth;
    }

    public static Tbuser getTbuser(String name, String phone, String gender, String birth){
        String id = UUID.randomUUID().toString().replace("-", "").substring(0,12);
        return new Tbuser(id,name,phone,gender,birth);

    }







}
