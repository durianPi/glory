package com.dreamlee.struct;

/**
 * @author: DreamLee
 * @date: Created on 20:26 2018/11/14
 * @description:
 * @modified:
 */
public class Linked<E> {

    private class Node<E> {
        private E e;
        private Node next;
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e) {
            this(e, null);
        }
        public Node() {
            this(null, null);
        }
    }

    private Node<E> dummyHead;

    private int size;

    public Linked() {
        dummyHead = new Node<>(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        Node pre = dummyHead;
        for (int i = 0; i < index; i++)
            pre = pre.next;
        pre.next = new Node(e, pre.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public Node remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        Node pre = dummyHead;
        for (int i = 0; i < index; i++)
            pre = pre.next;
        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode;
    }

    public Node removeFirst() {
        return remove(0);
    }

    public Node removeLast() {
        return remove(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        Node pre = dummyHead;
        for (int i = 0; i < index; i++)
            pre = pre.next;
        pre.next.e = e;
    }

    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        Node ret = dummyHead;
        for (int i = 0; i <= index; i++)
            ret = ret.next;
        return (E) ret.e;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Linked:size = %d\n", getSize()));
        stringBuilder.append("Head [");
        Node node = dummyHead;
        while (null != node) {
            stringBuilder.append(node.e);
            node = node.next;
            if (null != node) {
                stringBuilder.append("->");
            }
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }

}
