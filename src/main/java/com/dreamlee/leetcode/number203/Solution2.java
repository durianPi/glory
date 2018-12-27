package com.dreamlee.leetcode.number203;

/**
 * @author: DreamLee
 * @date: Created on 23:53 2018/11/17
 * @description: 使用虚拟头节点dummyHead
 * @modified:
 */
public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (null != prev.next) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

}
