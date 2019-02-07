package com.dreamlee.struct.impl;

/**
 * @author: DreamLee
 * @create: on 11:07 PM 1/16/19
 * @modify:
 * @desciption: 大顶堆
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent");
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int i) {
        while (i > 0 && data.get(i).compareTo(data.get(parent(i))) > 0) {
            data.swap(i, parent(i));
            i = parent(i);
        }
    }

    public E extractMax() {
        E ret = findMax();
        data.set(data.get(data.getSize() - 1), 0);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int i) {
        while (leftChild(i) < data.getSize()) {
            int j = leftChild(i);
            if (rightChild(i) < data.getSize() && data.get(j).compareTo(data.get(j+1)) < 0)
                j++;
            if (data.get(i).compareTo(data.get(j)) < 0) {
                data.swap(i, j);
                i = j;
            } else {
                break;
            }

        }
    }

    private E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        return data.get(0);
    }
}
