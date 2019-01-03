package com.dreamlee.struct.impl;

import com.dreamlee.struct.intf.Map;

/**
 * @author: dreamlee
 * @create: on 12:25 AM 1/3/19
 * @modify:
 * @desciption:
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private int size;
    private Node dummyHead;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    private Node getNode(K key) {
        if (null == key)
            throw new IllegalArgumentException("The key cannot be null!");
        Node curr = dummyHead.next;
        while (null != curr) {
            if (key.equals(curr.key))
                return curr;
            curr = curr.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        if (!contains(key)) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }
        else
            throw new IllegalArgumentException("The key has been added!");
    }

    @Override
    public V remove(K key) {
        if (!contains(key))
            return null;
        Node prev = dummyHead;
        while (null != prev.next) {
            Node curr = prev.next;
            if (key.equals(curr.key)) {
                prev.next = curr.next;
                size--;
                return curr.value;
            }
            prev = prev.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return null != getNode(key);
    }

    @Override
    public V get(K key) {
        return getNode(key).value;
    }

    @Override
    public void set(K key, V value) {
        if (!contains(key)) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }
        else
            getNode(key).value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node curr = dummyHead;
        while (null != curr.next) {
            sb.append(curr.next + "<-");
            curr = curr.next;
        }
        return sb.toString();
    }

    private class Node {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }

}
