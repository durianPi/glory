package com.dreamlee.struct;

import com.dreamlee.struct.intf.Stack;

/**
 * @author: DreamLee
 * @date: Created on 21:05 2018/11/13
 * @description:
 * @modified:
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> data;

    public ArrayStack(int capacity) {
        data = new Array<E>(capacity);
    }

    public ArrayStack() {
        this(8);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return 0 == getSize();
    }

    @Override
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public E peek() {
        return data.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("ArrayStack:size = %d, capacity = %d\n", getSize(), data.getCapacity()));
        stringBuilder.append("[");
        for (int i = 0; i < getSize(); i++) {
            stringBuilder.append(data.get(i));
            if (i != getSize() - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }
}
