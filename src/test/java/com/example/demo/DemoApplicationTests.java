package com.example.demo;


import com.example.demo.dao.UserInfoMapper;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	@Qualifier("mysqlDataSource")
	DataSource dataSource;

	@Autowired
	UserInfoMapper userInfoMapper;
	@Test
	public void contextLoads() {
//		System.out.println(dataSource.);
	}

}
