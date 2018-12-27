package com.dreamlee.struct;

import com.dreamlee.struct.intf.Queue;

/**
 * @author: DreamLee
 * @date: Created on 22:23 2018/11/13
 * @description:
 * @modified:
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int initCap;

    private int first;

    private int last;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity];
        first = 0;
        last = 0;
        initCap = capacity;
    }

    public LoopQueue() {
        this(8);
    }

    public int getCapacity() {
        return data.length;
    }

    @Override
    public int getSize() {
        if (last >= first) {
            return last - first;
        } else {
            return last - first + getCapacity();
        }
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * 队首删除元素
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty())
            throw new RuntimeException("队列为空，不能删除元素");
        E ret = data[first];
        first = (first + 1) % getCapacity();
        if (getSize() == getCapacity() >> 2 && (getCapacity() >> 1) >= initCap)
            resize(getCapacity() >> 1);
        return ret;
    }

    /**
     * 队尾增加元素
     * @param e
     */
    @Override
    public void enqueue(E e) {
        if (getSize() + 1 == getCapacity())
            resize(getCapacity() << 1);
        data[last] = e;
        last = (last + 1) % getCapacity();
    }

    private void resize(int cap) {
        E[] newData = (E[]) new Object[cap];
        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(i + first) % getCapacity()];
        }
        first = 0;
        last = getSize();
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("LoopQueue:size = %d, capacity = %d\n", getSize(), getCapacity()));
        stringBuilder.append("head [");
        for (int i = first; i != last; i = (i + 1) % getCapacity()) {
            stringBuilder.append(data[i]);
            if ((i + 1) % getCapacity() != last) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }

}
