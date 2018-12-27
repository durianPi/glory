package com.dreamlee.struct.intf;

/**
 * @author: DreamLee
 * @date: Created on 21:42 2018/12/5
 * @description: [describe the function]
 * @modified:
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();

}
