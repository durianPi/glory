package com.dreamlee.struct.intf;

/**
 * @author: DreamLee
 * @date: Created on 21:00 2018/11/13
 * @description:
 * @modified:
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    E dequeue();

    void enqueue(E e);

}
