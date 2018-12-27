package com.dreamlee.struct.test;

import com.dreamlee.struct.Array;
import com.dreamlee.struct.ArrayStack;
import com.dreamlee.struct.Linked;
import com.dreamlee.struct.LoopQueue;
import org.junit.Test;

/**
 * @author: DreamLee
 * @date: Created on 21:48 2018/11/7
 * @description:
 * @modified:
 */
public class MyTest {

    static {
        array = null;
    }

    private static Array<Integer> array = new Array<>();

    @Test
    public void test1() {
        Linked<Integer> list = new Linked<>();
        list.addFirst(0);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);
        list.addLast(0);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.add(1, 3);
        System.out.println(list);
        list.set(0, 8);
        System.out.println(list);
        System.out.println(list.get(0));
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        array.add(-1, 0);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array.toString());
        System.out.println(array.get(10));

        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);

        LoopQueue<Integer> queue = new LoopQueue<>(1);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(11);
        queue.enqueue(12);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }

}
