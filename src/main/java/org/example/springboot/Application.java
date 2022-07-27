package org.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application { // 앞으로 만들게 될 프로젝트의 메인 클래스
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);  //내장 was 실행
    }
}
