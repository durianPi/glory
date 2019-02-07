package test.internal;

import com.dreamlee.struct.impl.MaxHeap;
import org.junit.Test;

import java.util.Random;

/**
 * @author: DreamLee
 * @date: Created on 11:10 2018/1/31
 * @description:
 * @modified:
 */
public class MainExample {

    private class test1 extends Example1
    {
        public String name()
        {
            return super.name();
        }
    }
    private class test2 extends Example2
    {
        public int age()
        {
            return super.age();
        }
    }
    public String name()
    {
        return new test1().name();
}
    public int age()
    {
        return new test2().age();
    }
    public static void main(String args[])
    {
        MainExample mi=new MainExample();
        System.out.println("姓名:"+mi.name());
        System.out.println("年龄:"+mi.age());
    }

    @Test
    public void testArray() {
        int[] a = new int[8];
        System.out.println(a[0]);
    }

    @Test
    public void testMaxHeap() {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++)
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = maxHeap.extractMax();

        for (int i = 1; i < n; i++)
            if (arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");

        System.out.println("Test MaxHeap completed!");
    }

}
