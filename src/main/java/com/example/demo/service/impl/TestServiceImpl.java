package com.example.demo.service.impl;


import com.example.demo.dao.UserInfoMapper;
import com.example.demo.domain.UserInfo;
import com.example.demo.service.TestService;
import com.example.demo.vo.Response;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Response insertUser(UserInfo userInfo) {
        try{
            return new Response(0, "success", userInfoMapper.insert(userInfo));
        }catch (Exception e){
            e.printStackTrace();
            return new Response(-1, e.getMessage(), null);
        }

    }

    @Override
    public Response<List<UserInfo>> getAllUser() {
        try{
            return new Response(0, "success", userInfoMapper.selectAll());
        }catch (Exception e){
            e.printStackTrace();
            return new Response(-1, e.getMessage(), null);
        }
    }
}
