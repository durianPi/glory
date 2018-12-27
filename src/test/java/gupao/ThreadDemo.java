package gupao;

/**
 * @author: DreamLee
 * @date: Created on 19:51 2018/6/3
 * @description:
 * @modified:
 */
public class ThreadDemo {

    public synchronized void test() {

    }

    public void demo1() {
        synchronized (this) {

        }
    }

    public void demo2() {
        synchronized (ThreadDemo.class) { //全局锁 静态锁

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("1");
        });
        Thread t2 = new Thread(()->{
            System.out.println("2");
        });
        Thread t3 = new Thread(()->{
            System.out.println("3");
        });
        t1.start();//wait和notify
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
    }
}
