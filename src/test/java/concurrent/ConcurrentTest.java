package concurrent;

/**
 * @author: DreamLee
 * @date: Created on 0:12 2018/6/6
 * @description:
 * @modified:
 */
public class ConcurrentTest {

    public static void main(String[] args) {
        try {
            concurrency();
            serial();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static final Long count = 100000000L;

    private static void concurrency() throws InterruptedException {
        int a = 0;
        Long start = System.currentTimeMillis();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int b = 0;
                for (long i=0; i<count; i++) {
                    b--;
                }
            }
        });
        t.start();
        for (long i=0; i<count; i++) {
            a+=5;
        }
        t.join();
        Long end = System.currentTimeMillis();
        System.out.println("concurrency time is:" + (end-start));
    }

    private static void serial() {
        int a = 0,b = 0;
        Long start = System.currentTimeMillis();
        for (long i=0; i<count; i++) {
            a+=5;
        }
        for (long i=0; i<count; i++) {
            b--;
        }
        Long end = System.currentTimeMillis();
        System.out.println("serial time is:" + (end-start));
    }
}
