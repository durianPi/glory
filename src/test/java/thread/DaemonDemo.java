package thread;

/**
 * @author: DreamLee
 * @date: Created on 22:05 2018/6/4
 * @description: 后台线程是指在后台运行的线程，为其他线程提供服务，JVM的GC就是后台线程。
 * 如果前台线程全部死亡，后台线程会自动死亡。前台线程创建的子线程默认是前台线程，后台线程创建的子线程默认是后台线程。
 * 把某线程设置为后台线程的操作必须在线程启动之前，否则会抛异常。
 * @modified:
 */
public class DaemonDemo {
    public static void main(String[] args) {
        System.out.println("Start");
        DaemonThread dt = new DaemonThread();
        dt.setDaemon(true);
        dt.start();
        System.out.println("Done");
    }
}

class DaemonThread extends Thread {

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" +i);
        }
    }
}
