package com.xindong.springboottestfor.controller;

import com.xindong.springboottestfor.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {
    @Autowired
    Person person;

    @ResponseBody
    @RequestMapping("/list")
    public  String list(Model model){
       model.addAttribute("person",person);
        return "${person.name}";
    }
}
