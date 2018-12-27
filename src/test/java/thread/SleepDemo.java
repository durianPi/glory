package thread;

/**
 * @author: DreamLee
 * @date: Created on 17:52 2018/6/4
 * @description:Thread.sleep()
 * 可以让正在执行的线程暂停若干毫秒，并进入等待状态，时间到了之后自动恢复。
 * 在休眠时间范围内即使当前没有任何可执行的线程，休眠中的线程也不会被执行。
 * sleep()不释放对象锁，如果当前线程持有synchronized锁并sleep()，则其他线程仍不能访问。
 * @modified:
 */
public class SleepDemo {
    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            if(i == 5) {
                try {
                    Thread.sleep(5*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
