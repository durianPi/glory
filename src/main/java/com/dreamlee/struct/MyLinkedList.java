package com.dreamlee.struct;

/**
 * @author: DreamLee
 * @date: Created on 18:05 2018/11/18
 * @description: double direction linkedlist
 * @modified:
 */
public class MyLinkedList<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;
    private Node<E> dummyHead;

    public MyLinkedList() {
        dummyHead = new Node<E>(last, null, first);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E e) {
        boolean isContains = false;
        if (null != e) {
            Node<E> curr = dummyHead;
            while (null != curr.next) {
                if (e.equals(curr.next.e)) {
                    isContains = true;
                    break;
                } else
                    curr = curr.next;
            }
        }
        return isContains;
    }

    //add
    public boolean add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("illegal index");
        Node pre = dummyHead;
        for (int i = 0; i < index; i++)
            pre = pre.next;
        Node<E> nextNode = pre.next;
        Node<E> newNode = new Node<>(pre, e, nextNode);
        if (null != nextNode)
            nextNode.prev = newNode;
        else
            last = newNode;
        pre.next = newNode;
        size++;
        return true;
    }

    public void addLast(E e) {
        this.add(size, e);
    }

    public void addFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (null == f)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    //remove
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("illegal index");
        Node pre = dummyHead;
        for (int i = 0; i < index; i++)
            pre = pre.next;
        Node<E> ret = pre.next;
        pre.next = ret.next;
        if (null == ret.next)
            last = pre;
        else
            ret.next.prev = pre;
        size--;
        return ret.e;
    }

    public boolean removeElement(E e) {
        boolean success = false;
        if (null != e) {
            Node<E> pre = dummyHead;
            while (null != pre.next) {
                Node<E> curr = pre.next;
                if (e.equals(curr.e)) {
                    //delete current node
                    pre.next = curr.next;
                    if (null != curr.next)
                        curr.next.prev = pre;
                    curr = null;
                    success = true;
                    break;
                } else
                    pre = pre.next;
            }
        }
        return success;
    }

    //set
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("illegal index");
        Node<E> pre = getPreNode(index);
        pre.next.e = e;
    }

    //get
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("illegal index");
        Node<E> pre = getPreNode(index);
        return pre.e;
    }

    private Node<E> getPreNode(int index) {
        Node<E> dummyHead = new Node<E>(last, null, first);
        Node pre = dummyHead;
        for (int i = 0; i < index; i++)
            pre = pre.next;
        return pre;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Linked:size = %d\n", getSize()));
        stringBuilder.append("Head [");
        Node node = dummyHead.next;
        while (null != node) {
            stringBuilder.append(node.e);
            node = node.next;
            if (null != node) {
                stringBuilder.append("<->");
            }
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }

    class Node<E> {
        private Node<E> prev;
        private Node<E> next;
        private E e;
        Node(Node<E> prev, E e, Node<E> next) {
            this.prev = prev;
            this.e = e;
            this.next = next;
        }
        Node(E e) {
            this(null, e, null);
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(0, 1);
        list.add(1, 2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println(list);
        list.removeElement(4);
        list.removeElement(3);
        //list.remove(0);
        System.out.println(list);
    }

}
