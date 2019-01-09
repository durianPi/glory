package com.dreamlee.struct.impl;

import com.dreamlee.struct.intf.Map;

/**
 * @author: dreamlee
 * @create: on 10:15 PM 1/9/19
 * @modify:
 * @desciption:
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left,right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (null == node) {
            size++;
            return new Node(key, value);
        }
        else if (node.key.compareTo(key) > 0)
            return add(node.left, key, value);
        else if (node.key.compareTo(key) < 0)
            return add(node.right, key, value);
        else {
            node.value = value;
            return node;
        }
    }

    @Override
    public V remove(K key) {
        if (null == key)
            return null;
        else {
            Node node = remove(root, key);
            return node == null ? null : node.value;
        }
    }

    private Node remove(Node node, K key) {
        if (null == node)
            return null;
        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        }
        else if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        }
        else {
            if (null == node.left) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }
            else if (null == node.right) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }
            else {
                Node ret = minimum(node.right);
                ret.right = removeMin(node.right);
                ret.left = node.left;
                //System.out.println("abc");
                node = null;
                return  ret;
            }
        }
    }

    private Node minimum(Node node) {
        if (null == node)
            return null;
        if (null == node.left)
            return node;
        else
            return minimum(node.left);
    }

    private Node removeMin(Node node) {
        if (null == node)
            return null;
        if (null == node.left) {
            Node right = node.right;
            node = null;
            size--;
            return right;
        }
        else
            return removeMin(node.left);
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        V value = null;
        Node node = getNode(root, key);
        if (null != node)
            value = node.value;
        return value;
    }

    /**
     *
     * @return 返回以node为根结点的二分搜索树中，key所在的节点
     */
    private Node getNode(Node node, K key) {
        if (null == node)
            return null;
        if (node.key.compareTo(key) > 0)
            return getNode(node.left, key);
        else if (node.key.compareTo(key) < 0)
            return getNode(node.right, key);
        else
            return node;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (null == node)
            add(key, value);
        else
            node.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
