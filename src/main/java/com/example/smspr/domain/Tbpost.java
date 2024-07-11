package com.example.smspr.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Table //그냥 같이 달아주자 일단 지금은 활용안했음
@Entity
//@Entity를 통해서 sql에 테이블을 만들어줌

public class Tbpost {
    //2024-07-11
    @Id //pk
    private String id;
    @Setter @Column private String title;
    @Setter @Column private String content;

    public Tbpost(){
        
    }

    private Tbpost(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
    public static Tbpost of(String title, String content){
        String id = UUID.randomUUID().toString().replace("-", "").substring(0,12);
        return new Tbpost(id, title, content);
    }

}

