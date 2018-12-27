package com.dreamlee.leetcode.number203;

/**
 * @author: DreamLee
 * @date: Created on 23:53 2018/11/17
 * @description: 未使用虚拟头节点
 * @modified:
 */
public class Solution1 {

    public ListNode removeElements(ListNode head, int val) {
        while (null != head && head.val == val) {
            head = head.next;
        }
        if (null == head)
            return null;
        ListNode prev = head;
        while (null != prev) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

}
