package com.example.demo.job;

import com.example.demo.service.TestService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BatchJob implements  Job {

    @Autowired
    TestService testService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        try {
            testService.testdb();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}