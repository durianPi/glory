package com.dreamlee.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author: DreamLee
 * @date: Created on 22:28 2018/11/1
 * @description:
 * @modified:
 */
public class FirstScheduledJob extends QuartzJobBean {

    private AnotherBean anotherBean;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("FirstScheduledJob Executes");
        this.anotherBean.printAnotherMessage();
    }

    public void setAnotherBean(AnotherBean anotherBean) {
        this.anotherBean = anotherBean;
    }
}
