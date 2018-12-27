package com.dreamlee.struct;

/**
 * @author: DreamLee
 * @date: Created on 23:20 2018/11/5
 * @description:
 * @modified:
 */
public class Array<E> {
    //泛型数组
    private E data[];
    //数组大小
    private int size;
    //初始容量
    private int initCap;
    //Array(int)
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
        initCap = capacity;
    }
    //Array
    public Array() {
        this(8);
    }
    //getCapacity
    public int getCapacity() {
        return data.length;
    }
    //getSize
    public int getSize() {
        return size;
    }
    //isEmpty
    public boolean isEmpty() {
        return size == 0;
    }
    //add
    public void add(E e, int index) {
        isIllegal(index);
        //如果容量满了，则数组扩容两倍
        if (data.length == size)
            resize(2 * size);

        if (isEmpty())
            data[0] = e;
        else {
            for (int i = size; i > index; i--)
                data[i] = data[i - 1];
            data[index] = e;
        }
        size++;
    }
    //addFirst
    public void addFirst(E e) {
        add(e, 0);
    }
    //addLast
    public void addLast(E e) {
        add(e, size);
    }
    //get
    public E get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("The index of array is illegal.");
        return data[index];
    }
    //getLast
    public E getLast() {
        return get(size - 1);
    }
    //getFirst
    public E getFirst() {
        return get(0);
    }
    //set
    public void set(E e, int index) {
        isIllegal(index);
        data[index] = e;
    }
    //contains包含
    public boolean contains(E e) {
        boolean isContains = false;
        if (null != e)
            for (int i = 0; i < size; i++)
                if (e.equals(data[i])) {
                    isContains = true;
                    break;
                }
        return isContains;
    }
    //find搜索
    public int find(E e) {
        int index = -1;
        if (null != e)
            for (int i = 0; i < size; i++)
                if (e.equals(data[i])) {
                    index = i;
                    break;
                }
        return index;
    }
    //findAll搜索
//    public int[] findAll(E e) {
//        int[] index = new int[size];
//        if (null != e)
//            for (int i = 0; i < size; i++)
//                if (e.equals(data[i])) {
//                    index[i] = i;
//                }
//
//        return index;
//    }
    //remove
    public E remove(int index) {
        isIllegal(index);
        for (int i = index; i < size - 1; i++)
            data[i] = data[i+1];
        data[size - 1] = null;
        size--;
        //考虑缩容触发条件
        if (size == data.length >> 2 && (data.length >> 1) >= initCap) {
            resize(data.length >> 1);
        }
        return data[index];
    }
    //removeFirst
    public E removeFirst() {
        return remove(0);
    }
    //removeLast
    public E removeLast() {
        return remove(size - 1);
    }
    //removeElement
    public boolean removeElement(E e) {
        int index = find(e);
        if (-1 != index) {
            remove(index);
            return true;
        }
        return false;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array:size = %d, capacity = %d\n", getSize(), getCapacity()));
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    //
    private boolean isIllegal(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("The index of array is illegal.");
        return true;
    }

    //扩容
    private void resize(int newSize) {
        E newData[] = (E[]) new Object[newSize];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

}
