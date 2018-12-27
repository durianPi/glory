package sync;

/**
 * @author: DreamLee
 * @date: Created on 23:03 2018/6/5
 * @description: 什么时候当前线程会释放监视器的锁？
 * 1.当synchronized块&方法执行完毕；
 * 2.当synchronized块&方法执行中使用break&return跳出来时；
 * 3.当synchronized块&方法执行中遇到exception或error跳出来时；
 * 4.当synchronized块&方法执行中使用了监视器所属对象的wait()时；
 * 什么时候当前线程不会释放监视器的锁？
 * Thread.sleep()、Thread.yield()、Thread.suspend()。
 * @modified:
 */
public class SynchronizedDemo2 {

    public static void main(String[] args) {
        Item item = new Item();
        item.count = 1;
        item.name = "java";
        SynchronizedThread st = new SynchronizedThread(item);
        for (int i=0; i<10; i++) {
            new Thread(st).start();
        }
    }

}

class Item {
    String name;
    int count;
}

class SynchronizedThread implements Runnable {

    private Item item;

    public SynchronizedThread(Item item) {
        this.item = item;
    }

    @Override
    public void run() {
        synchronized (item) {
            if (item.count <= 0) {
                System.out.println("购买失败，商品已经卖完了");
            } else {
                System.out.println("购买成功");
                item.count --;
            }
        }
    }
}
