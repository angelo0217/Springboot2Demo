package com.example.demo.controller.page;

import com.example.demo.domain.UserInfo;
import com.example.demo.service.TestService;
import com.example.demo.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2019/1/4
 *
 * @author dean
 * @email loveangelo0217@gmail.com
 * @since 1.0
 */
@RestController
public class UserController {
    @Autowired
    TestService testService;

    @PostMapping("/inserUser")
    public Response inserUser(@RequestBody UserInfo userInfo){
        return testService.insertUser(userInfo);
    }

    @GetMapping ("/query")
    public Response queryUser(){
        return testService.getAllUser();
    }
}
