package com.example.smspr.repository;

import com.example.smspr.domain.Tbpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;


//String 인 이유는 primary key가 String이기 때문. 하지만 그냥 다른 걸로 써도 됌
@RestController
public interface TbpostRepository extends JpaRepository<Tbpost,String> {


}
