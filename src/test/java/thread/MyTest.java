package thread;

import org.junit.Test;

/**
 * @author: DreamLee
 * @date: Created on 15:22 2018/10/14
 * @description:
 * @modified:
 */
public class MyTest {

    @Test
    public void testThread() {
        MyThreadInner myTh = new MyThreadInner();
        myTh.start();
        System.out.println("abc");
    }

}
class MyThreadInner extends Thread {//继承Thread

    @Override
    public void run() {
        while(true){
            System.out.println("=== "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
