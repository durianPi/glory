package com.dreamlee.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * @author: DreamLee
 * @date: Created on 21:18 2018/10/30
 * @description:
 * @modified:
 */
public class MyTimer {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        MyTimerTask myTimerTask1 = new MyTimerTask("NO.1");
        MyTimerTask myTimerTask2 = new MyTimerTask("NO.2");
//        timer.schedule(myTimerTask, 1000l, 1000);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        calendar.add(Calendar.SECOND, 3);
        System.out.println("current time is " + simpleDateFormat.format(calendar.getTime()));
//        timer.schedule(myTimerTask, calendar.getTime());

        timer.scheduleAtFixedRate(myTimerTask1, 1000, 1000);
        timer.schedule(myTimerTask2, 1000, 1000);

        Thread.sleep(5000);
        myTimerTask2.cancel();
        myTimerTask1.cancel();
        System.out.println("cancel thread numbers: " + timer.purge());
        System.out.println("cancel time is " + simpleDateFormat.format(new Date()));
    }
}
