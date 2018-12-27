package com.dreamlee.struct;

import com.dreamlee.struct.intf.Queue;

/**
 * @author: DreamLee
 * @date: Created on 22:16 2018/11/13
 * @description:
 * @modified:
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> data;

    public ArrayQueue(int capacity) {
        data = new Array<>(capacity);
    }

    public ArrayQueue() {
        this(8);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("ArrayQueue:size = %d, capacity = %d\n", getSize(), data.getCapacity()));
        stringBuilder.append("head [");
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
