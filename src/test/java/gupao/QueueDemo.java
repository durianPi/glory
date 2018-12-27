package gupao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: DreamLee
 * @date: Created on 15:40 2018/6/5
 * @description: 利用多线程去实现一个阻塞的安全队列利用多线程去实现一个阻塞的安全队列
 * @modified:
 */
public class QueueDemo {

    private volatile int a = 0;
    private AtomicInteger b = new AtomicInteger(0);
    public void add() {
        for(int i=0; i<100; i++) {
            a++;
        }
        System.out.println(a);
    }

    private List<String> list = new ArrayList<>();
    private Object lock = new Object();
    private int size;

    //对这个队列大小进行初始化
    public QueueDemo(int size) {
        this.size = size;
        System.out.println(Thread.currentThread().getName() + "初始化完成，大小为:" +size);
    }

    //存数据
    public void put(String data) {
        synchronized (lock) {
            if(this.list.size() == size) {
                //说明队列已经满了
                System.out.println(Thread.currentThread().getName() + "当前队列已经满了，需要等待。。。");
                //得让出cpu资源
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //装的进去的时候
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.list.add(data);
            System.out.println(Thread.currentThread().getName() + "已经将" + data + "元素装进队列中了");

            //通知其他线程来取/存
            lock.notifyAll();
        }
    }

    //取数据
    public String get() {
        synchronized (lock) {
            //判断队列是否为空，如果为空，则等待
            if(this.list.size() == 0) {
                System.out.println(Thread.currentThread().getName() + "当前队列已经满了，需要等待。。。");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //从队列中取数据
            String data = list.get(0);
            list.remove(0);//队列数据取完之后，需要移除
            System.out.println(Thread.currentThread().getName() + "已经取到" + data + "元素了");
            lock.notifyAll();//通知其他线程可以存元素
            return data;
        }
    }

    public static void main(String[] args) {
        final QueueDemo queueDemo = new QueueDemo(6);

        //创建一个线程，去执行存取的任务
        new Thread(new Runnable() {
            @Override
            public void run() {
                queueDemo.put("jack1");
                queueDemo.put("jack2");
                queueDemo.put("jack3");
                queueDemo.put("jack4");
                queueDemo.put("jack5");
                queueDemo.put("jack6");
                queueDemo.put("jack7");
            }
        },"线程T1").start();

        //创建一个线程，去执行存取的任务
        new Thread(new Runnable() {
            @Override
            public void run() {
                queueDemo.put("jack111");
                queueDemo.put("jack222");
                queueDemo.put("jack333");
                queueDemo.put("jack444");
                queueDemo.put("jack555");
                queueDemo.put("jack666");
                queueDemo.put("jack777");
            }
        },"线程T1-1").start();

        //创建一个线程来取
        new Thread(new Runnable() {
            @Override
            public void run() {
                queueDemo.get();
                queueDemo.get();
            }
        },"线程T2").start();
    }
}
