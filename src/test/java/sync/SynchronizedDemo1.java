package sync;

/**
 * @author: DreamLee
 * @date: Created on 22:53 2018/6/5
 * @description:
 * @modified:
 */
public class SynchronizedDemo1 implements Runnable {

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo1 sd1 = new SynchronizedDemo1();
        Thread t1 = new Thread(sd1);
        Thread t2 = new Thread(sd1);
        Thread t3 = new Thread(sd1);
        t1.start();
        t2.start();
        t3.start();
    }
}
