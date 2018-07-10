package com.springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2018-6-14.
 */
@SpringBootApplication
@RestController
public class DemoApplication {

    @RequestMapping("/")
    public String home(){
        return "hello";
    }

    public static void main(String[] args){
        SpringApplication.run(DemoApplication.class,args);
    }
}
