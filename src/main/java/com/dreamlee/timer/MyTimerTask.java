package com.dreamlee.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

/**
 * @author: DreamLee
 * @date: Created on 21:16 2018/10/30
 * @description:
 * @modified:
 */
public class MyTimerTask extends TimerTask {
    private String name;

    private int count;

    public MyTimerTask(String inputName) {
        name = inputName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        if (count < 3) {
            //以yyyy-MM-dd HH:mm:ss格式打印当前时间
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(simpleDateFormat.format(calendar.getTime()));
            System.out.println(name + " is executing...");
//            count++;
        } else {
//            cancel();
            System.out.println(name + " is canceled");
        }
    }
}
