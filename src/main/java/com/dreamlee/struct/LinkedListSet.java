package com.dreamlee.struct;

import com.dreamlee.struct.intf.Set;

/**
 * @author: LinkedListSet
 * @create: 2019/1/1 9:04 PM
 * @modify:
 * @desciption:
 */
public class LinkedListSet<E> implements Set<E> {

    private MyLinkedList<E> list;

    public LinkedListSet() {
        list = new MyLinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e))
            list.addFirst(e);
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
