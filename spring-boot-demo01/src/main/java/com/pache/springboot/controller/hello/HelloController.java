package com.pache.springboot.controller.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController 当一个类使用该注解时，相当于使用了 Controller  和ResponseBody 所以这个类只能返回具体的数据
 * 而不是一个页面视图
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "Greetings from Spring Boot!";
    }
}
