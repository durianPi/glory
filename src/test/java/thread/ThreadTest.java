package thread;

/**
 * @author: DreamLee
 * @date: Created on 11:14 2018/5/15
 * @description:
 * @modified:
 */
public class ThreadTest implements Runnable {
    private int num = 0;
    @Override
    public void run() {
        while (num < 100) {
            System.out.println(Thread.currentThread().getName() + ":" + num++);
        }
    }

    public static void main(String[] args) {
        ThreadTest tt1 = new ThreadTest();
        ThreadTest tt2 = new ThreadTest();
        ThreadTest tt3 = new ThreadTest();
        Thread t1 = new Thread(tt1);
        Thread t2 = new Thread(tt2);
        Thread t3 = new Thread(tt3);
        t1.start();
        t2.start();
        t3.start();
    }
}
