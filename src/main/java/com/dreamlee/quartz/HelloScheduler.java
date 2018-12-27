package com.dreamlee.quartz;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: DreamLee
 * @date: Created on 8:57 2018/11/1
 * @description:
 * @modified:
 */
public class HelloScheduler {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myJob", "group1")
                .build();

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))
                .build();
        //1.2017年内每天10点15分触发一次 -> 0 15 10 ? * * 2017
        //2.每天的14点整至14点59分55秒，以及18点至18点59分55秒，每5秒触发一次 -> 0/5 * 14,18 * * ?


        StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("current time is: " + simpleDateFormat.format(new Date()));

        Date date = scheduler.scheduleJob(jobDetail, trigger);
        System.out.println(simpleDateFormat.format(date));

        Thread.sleep(3000);
        scheduler.standby();
        Thread.sleep(3000);
        scheduler.start();
    }
}
