package com.dreamlee.quartz;

import org.springframework.stereotype.Component;

/**
 * @author: DreamLee
 * @date: Created on 22:36 2018/11/1
 * @description:
 * @modified:
 */
@Component("anotherBean")
public class AnotherBean {

    public void printAnotherMessage() {
        System.out.println("I am AnotherBean");
    }

}
