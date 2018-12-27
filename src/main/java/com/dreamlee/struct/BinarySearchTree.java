package com.dreamlee.struct;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: DreamLee
 * @date: Created on 22:12 2018/11/24
 * @description: 二分查找树
 * @modified:
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private Node<E> root;
    private int size;

    class Node<E> {
        private E e;
        private Node<E> left;
        private Node<E> right;
        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }
        public Node(E e) {
            this(e, null, null);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(E e) {
        if (null == e)
            return false;
        else {
            root = add(root, e);
            return true;
        }
    }

    private Node<E> add(Node<E> node, E e) {
        if (null == node) {
            size++;
            return new Node<E>(e);
        }
        if (node.e.compareTo(e) < 0) {
            node.right = add(node.right, e);
        }
        if (node.e.compareTo(e) > 0)
            node.left = add(node.left, e);
        //node.e和e是相等的情况
        return node;
    }

    public boolean remove(E e) {
        if (null == e)
            return false;
        else {
            root = remove(root, e);
            return true;
        }
    }

    /**
     *
     * @param node
     * @param e
     * @return
     */
    private Node<E> remove(Node<E> node, E e) {
        if (null == node)
            return null;
        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        else if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
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
                // 待删除节点左右子树均不为空的情况，找到比待删除节点大的最小节点，
                // 即待删除节点右子树的最小节点，用这个节点顶替待删除节点的位置
                Node ret = minimum(node.right);
                ret.right = removeMin(node.right);
                ret.left = node.left;
                System.out.println("abc");
                node = null;
                return  ret;
            }
        }
    }

    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }
    private Node<E> removeMin(Node<E> node) {
        if (null == node.left) {
            Node<E> rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }
    private Node<E> removeMax(Node<E> node) {
        if (null == node.right) {
            Node<E> leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return minimum(root).e;
    }
    private Node<E> minimum(Node<E> node) {
        if (null == node.left) {
            return node;
        }
        return minimum(node.left);
    }
    private Node<E> minimum2(Node<E> node) {
        while (null != node.left) {
            node = node.left;
        }
        return node;
    }

    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).e;
    }
    private Node<E> maximum(Node<E> node) {
        if (null == node.right) {
            return node;
        }
        return maximum(node.right);
    }
    private Node<E> maximum2(Node<E> node) {
        while (null != node.right) {
            node = node.right;
        }
        return node;
    }

    public boolean contains(E e) {
        if (null == e || !contains(root, e))
            return false;
        else
            return true;
    }

    @Override
    public String toString() {
        return print(root);
    }

    private boolean contains(Node<E> node, E e) {
        if (null == node)
            return false;
        if (node.e.compareTo(e) == 0)
            return true;
        else if (node.e.compareTo(e) < 0)
            return contains(node.right, e);
        else
            return contains(node.left, e);
    }

    //深度优先遍历
    private String print(Node<E> node) {
        StringBuilder sb = new StringBuilder();
        if (null != node) {
            sb.append(print(node.left));
            sb.append(node.e + " ");
            sb.append(print(node.right));
        }
        return sb.toString();
    }

    //深度优先遍历2
    public void deepOrder() {
        Stack<Node<E>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<E> pop = stack.pop();
            System.out.println(pop.e);
            if (null != pop.right)
                stack.push(pop.right);
            if (null != pop.left)
                stack.push(pop.left);
        }
    }

    //广度优先遍历
    public void levelOrder() {
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<E> remove = queue.remove();
            System.out.println(remove.e);
            if (null != remove.left)
                queue.add(remove.left);
            if (null != remove.right)
                queue.add(remove.right);
        }
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(5);
        bst.add(7);
        bst.add(3);
        bst.add(9);
        bst.add(9);
        bst.add(1);
        bst.add(8);
        bst.add(2);
        bst.add(6);
        bst.add(4);
        //bst.levelOrder();
        System.out.println(bst);
        bst.remove(5);
//        bst.removeMax();
        System.out.println(bst);
        //System.out.println(new Integer(1).compareTo(new Integer(2)));
    }

}
