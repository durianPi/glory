package thread;

/**
 * @author: DreamLee
 * @date: Created on 20:33 2018/5/14
 * @description:
 * @modified:
 */
public class MyThread2 extends Thread {
    static int num = 1;
    private Object present;
    private Object previous;

    public MyThread2() {}

    public MyThread2(Object present, Object previous) {
        this.present = present;
        this.previous = previous;
    }

    @Override
    public void run() {
        int n = 100;
        while (num < n) {
            synchronized (previous) {
                synchronized (present) {
                    for(int i=0; i<3; i++) {
                        System.out.println(Thread.currentThread().getName() + ":" + num++);
                        if(num > n) {
                            return;
                        }
                    }
                    present.notify();
                }
                try {
                    previous.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        Thread t1 = new MyThread2(o1, o3);
        Thread t2 = new MyThread2(o2, o1);
        Thread t3 = new MyThread2(o3, o2);
        t1.start();
//        Thread.sleep(500);
        t2.start();
//        Thread.sleep(500);
        t3.start();
    }
}
