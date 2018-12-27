package thread;

/**
 * @author: DreamLee
 * @date: Created on 20:56 2018/6/4
 * @description:
 * @modified:
 */
public class PriorityDemo {
    public static void main(String[] args) {
        PriorityThread pt1 = new PriorityThread();
        PriorityThread pt2 = new PriorityThread();
        pt1.setPriority(Thread.MAX_PRIORITY);
        pt2.setPriority(Thread.MIN_PRIORITY);
        pt1.start();
        pt2.start();
        System.out.println("得到线程优先级t1=" + pt1.getPriority());
        System.out.println("得到线程优先级t2=" + pt2.getPriority());
    }
}

class PriorityThread extends Thread {

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" +i);
        }
    }
}