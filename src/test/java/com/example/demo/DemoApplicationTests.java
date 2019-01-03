package com.example.demo;


import com.example.demo.dao.UserInfoMapper;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


	@Autowired
	UserInfoMapper userInfoMapper;
	@Test
	public void contextLoads() {
//		System.out.println(new Gson().toJson(userMainMapper.select(2)));
	}

}
