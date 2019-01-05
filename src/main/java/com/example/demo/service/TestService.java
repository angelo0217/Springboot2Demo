package com.example.demo.service;

import com.example.demo.domain.UserInfo;
import com.example.demo.vo.Response;

import java.util.List;

public interface TestService {
    void testdb() throws Exception;
    public void testpring() throws Exception;

    Response insertUser(UserInfo userInfo);

    Response<List<UserInfo>> getAllUser();
}
