package thread;

/**
 * @author: DreamLee
 * @date: Created on 20:25 2018/6/4
 * @description:Thread.yield()
 * 使当前线程放弃CPU调度，但是不使线程阻塞&等待，即线程仍处于可执行状态，随时可能再次获取CPU调度。
 * 相当于认为当前线程已执行了足够的时间从而转到另一个线程。也有可能出现刚调用完Thread.yield()放弃CPU调度，当前线程立刻又获得CPU调度。
 * @modified:
 */
public class YieldDemo {
    public static void main(String[] args) {
        YieldDemo1 yd1 = new YieldDemo1();
        Thread t1 = new Thread(yd1);
        Thread t2 = new Thread(yd1);
        t1.start();
        t2.start();
    }
}

class YieldDemo1 implements Runnable {

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            if(i == 50) {
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
