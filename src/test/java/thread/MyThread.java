package thread;

/**
 * @author: DreamLee
 * @date: Created on 20:33 2018/5/14
 * @description:
 * @modified:
 */
public class MyThread implements Runnable {
    private int num = 1;

    public MyThread() {}

    @Override
    public void run() {
        synchronized (this) {
            for (int i = num; num <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + num++);
                if (i % 3 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);
        Thread t3 = new Thread(myThread);
        t1.start();
        t2.start();
        t3.start();
    }
}
