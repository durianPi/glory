package thread;

/**
 * @author: DreamLee
 * @date: Created on 17:12 2018/5/15
 * @description:
 * @modified:
 */
public class SynchronizedABC extends Thread {

    private String name;
    private Object pre;
    private Object self;


    public SynchronizedABC(String name, Object pre, Object self) {
        this.name = name;
        this.pre = pre;
        this.self = self;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            synchronized (pre) {
                synchronized (self) {
                    System.out.println(Thread.currentThread().getName()+":"+name);
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+"Before notifyAll()");
                    self.notifyAll();
                    System.out.println(Thread.currentThread().getName()+":"+"After notifyAll()");
                }
                try {
                    System.out.println(Thread.currentThread().getName()+":"+"Before wait()");
                    pre.wait();
                    System.out.println(Thread.currentThread().getName()+":"+"wait "+name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        new SynchronizedABC("A", c, a).start();
        Thread.sleep(0);
        new SynchronizedABC("B", a, b).start();
        Thread.sleep(0);
        new SynchronizedABC("C", b, c).start();

//        Thread.currentThread().join();


    }
}
