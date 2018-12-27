package thread;

/**
 * @author: DreamLee
 * @date: Created on 17:15 2018/6/4
 * @description:
 * @modified:
 */
public class JoinDemo {

    public static void main(String[] args) {
        System.out.println("Start");
        JoinDemo1 jd1 = new JoinDemo1();
        Thread t1 = new Thread(jd1);
        Thread t2 = new Thread(jd1);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            //主线程等待t1,t2两个线程都执行完毕再继续往下走。
            //此处t1,t2会并发执行，并不会因为t1.join()先调用就执行完t1再执行t2，
            //join()方法也可以加入超时时间，如果超过时间则不再等待
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }

}

class JoinDemo1 implements Runnable {

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
