package com.dreamlee.struct;

import com.dreamlee.struct.intf.Set;

/**
 * @author: DreamLee
 * @date: Created on 22:03 2018/12/5
 * @description: [describe the function]
 * @modified:
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree<E> bst;

    public BSTSet() {
        bst = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
