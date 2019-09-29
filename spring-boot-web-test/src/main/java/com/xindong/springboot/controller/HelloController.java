package com.xindong.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/login")
    public  String login(Map<String,Object> map){
        map.put("hello","张三");
        map.put("name" ,"<h1> zhangsan</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "login";
    }

}
