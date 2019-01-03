package com.example.demo.service.impl;


import com.example.demo.dao.UserInfoMapper;
import com.example.demo.service.TestService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    UserInfoMapper userInfoMapper;

    public void testdb() throws Exception{
       System.out.println(new Gson().toJson(userInfoMapper.selectByPrimaryKey(1)));
    }
    
    public void testpring() throws Exception{
        System.out.println("OK THREAD");
    }
}
