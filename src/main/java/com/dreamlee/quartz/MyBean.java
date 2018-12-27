package com.dreamlee.quartz;

import org.springframework.stereotype.Component;

/**
 * @author: DreamLee
 * @date: Created on 20:44 2018/11/1
 * @description:
 * @modified:
 */
@Component("myBean")
public class MyBean {

    public void printMessage() {
        System.out.println("MyBean Executes!");
    }
}
