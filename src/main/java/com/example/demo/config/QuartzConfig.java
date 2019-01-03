package com.example.demo.config;

import com.example.demo.Const;
import com.example.demo.job.BatchJob;
import com.example.demo.utils.JobUtils;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan("com.example.demo.job")
public class QuartzConfig {
    @Autowired
    JobUtils jobUtils;

    @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext )
    {
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    /**
     * 此Method負責添加Job
     * @param jobFactory
     * @return
     * @throws IOException
     */
    @Bean("scheduler")
    public SchedulerFactoryBean schedulerFactoryBean( JobFactory jobFactory) throws IOException {

        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setOverwriteExistingJobs(true);
        factory.setJobFactory(jobFactory);
        factory.setQuartzProperties(quartzProperties());
        //在這裡設定Job，用","分開
        factory.setTriggers(cornSampleJobTrigger().getObject());

        return factory;
    }
    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    private static JobDetailFactoryBean createJobDetail(Class jobClass) {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(jobClass);
        factoryBean.setDurability(true);
        return factoryBean;
    }
    /** 基本設定如下**/
    @Bean
    public CronTriggerFactoryBean cornSampleJobTrigger(){
        CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
        stFactory.setJobDetail(beanBatchJob().getObject());
        stFactory.setStartDelay(1000);
        stFactory.setName("BatchJobTrigger");
        stFactory.setGroup(Const.BATCH_GROUP);
        stFactory.setCronExpression("*/10 * * * * ?");
        return stFactory;
    }

    @Bean
    public JobDetailFactoryBean beanBatchJob(){
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(BatchJob.class);
        factoryBean.setGroup(Const.BATCH_GROUP);
        factoryBean.setName("BatchJob");
        return factoryBean;
    }
    /**end**/


}
