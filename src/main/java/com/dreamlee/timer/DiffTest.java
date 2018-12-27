package com.dreamlee.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: DreamLee
 * @date: Created on 13:56 2018/10/31
 * @description:
 * @modified:
 */
public class DiffTest {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("current time is : " + simpleDateFormat.format(calendar.getTime()));

//        calendar.add(Calendar.SECOND, -6);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println(String.format("Scheduled exec time is: "
                            + simpleDateFormat.format(scheduledExecutionTime())));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, calendar.getTime(), 1000);
    }
}
