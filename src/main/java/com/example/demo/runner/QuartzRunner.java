package com.example.demo.runner;

import com.example.demo.utils.JobUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 利用Runner 在Server啟動後，設定Job(可以改成讀DB 來設定)
 */
@Component
@Order(1)
public class QuartzRunner implements CommandLineRunner {
    @Autowired
    BeanFactory beanFactory;
    @Autowired
    JobUtils jobUtils;

    @Override
    public void run(String... args) throws Exception
    {
//        System.out.println("===MyStartupRunnerTest1执行，它的@Order注解value值为1===");
//        JobParameter param = new JobParameter();
//        param.setJobName("Job");
//        param.setJobGroup("TEST");
//        param.setCronExpression("0/5 * * * * ?");
//        param.setDescription("Execute job  every 5 seconds ...");
//
//        Scheduler scheduler = (Scheduler) beanFactory.getBean("scheduler");
//
//        jobUtils.addJob("com.test.job.BatchJob", param, scheduler);
        //ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
