package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: DreamLee
 * @date: Created on 10:40 2018/6/4
 * @description:
 * @modified:
 */
public class CallableDemo {
    public static void main(String[] args) {
        FutureTask<Boolean> ft1 = new FutureTask<Boolean>(new CallableDemo1(1));
        FutureTask<Boolean> ft2 = new FutureTask<Boolean>(new CallableDemo1(0));
        FutureTask<Boolean> ft3 = new FutureTask<Boolean>(new CallableDemo1(2));
        Thread t1 = new Thread(ft1);
        Thread t2 = new Thread(ft2);
        Thread t3 = new Thread(ft3);
        t1.start();
        t2.start();
        t3.start();

        try {
            System.out.println(ft1.get());
            System.out.println(ft2.get());
            System.out.println(ft3.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class CallableDemo1 implements Callable<Boolean> {
    int flag;
    int i = 0;

    public CallableDemo1(int flag) {
        this.flag = flag;
    }

    @Override
    public Boolean call() throws Exception {
        for( ; i<10; i++) {
            System.out.println(Thread.currentThread().getName() + "==>" + i);
        }
        if(0 == flag)
            return false;
        else if(1 == flag)
            return true;
        else
            throw new Exception("An Exception occured");
    }
}
