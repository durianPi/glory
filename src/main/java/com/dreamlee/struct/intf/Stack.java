package com.dreamlee.struct.intf;

/**
 * @author: DreamLee
 * @date: Created on 20:57 2018/11/13
 * @description:
 * @modified:
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();

}
