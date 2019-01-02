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

    @Override
    public void add(K key, V value) {

    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void set(K key, V value) {

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
