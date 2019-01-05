package com.example.demo.controller.page;

import com.example.demo.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping(value = Const.PAGE_PATH)
public class WelcomeController{

    @RequestMapping("/helloJsp")
    public String helloJsp(Map<String,Object> map){
        map.put("hello", "Hi");
        return "page/helloJsp";
    }
    @RequestMapping("/queryPage")
    public String queryPage(){
        return "page/queryPage";
    }
}