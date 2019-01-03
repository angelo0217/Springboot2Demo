package com.example.demo.utils;

import com.example.demo.vo.JobParameterVO;
import org.quartz.*;
import org.springframework.stereotype.Component;

@Component
public class JobUtils {
    /**
     * 新增Job
     * @param classPath
     * @param param
     * @param scheduler
     * @throws Exception
     */
    public void addJob(String classPath, JobParameterVO param, Scheduler scheduler) throws Exception{
        Class cls = Class.forName(classPath);
        JobDetail jobDetail = JobBuilder.newJob(cls) .withIdentity(param.getJobName(), param.getJobGroup()).build();
        // 表达式调度构建器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(param.getCronExpression());
        // 按cronExpression表达式构建trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(param.getJobName(), param.getJobGroup())
                .withSchedule(scheduleBuilder).build();
        // 放入参数，运行时的方法可以获取
        jobDetail.getJobDataMap().put("jobParam", param);
        scheduler.scheduleJob(jobDetail, trigger);
    }

    /**
     * 刪除Job
     * @param jobName
     * @param jobGroup
     * @param scheduler
     * @throws Exception
     */
    public void removeJob(String jobName, String jobGroup, Scheduler scheduler) throws Exception{
        scheduler.deleteJob(JobKey.jobKey(jobName, jobGroup));
    }

    /**
     * 暫停Job
     * @param jobName
     * @param jobGroup
     * @param scheduler
     * @throws Exception
     */
    public void pauseJob(String jobName, String jobGroup, Scheduler scheduler) throws Exception{
        scheduler.pauseJob(JobKey.jobKey(jobName, jobGroup));
    }

    /**
     * 重啟Job
     * @param jobName
     * @param jobGroup
     * @param scheduler
     * @throws Exception
     */
    public void resumeJob(String jobName, String jobGroup, Scheduler scheduler) throws Exception{
        scheduler.resumeJob(JobKey.jobKey(jobName, jobGroup));
    }
}
