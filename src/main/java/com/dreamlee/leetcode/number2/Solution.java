package com.dreamlee.leetcode.number2;

/**
 * @author: DreamLee
 * @date: Created on 19:39 2018/12/5
 * @description: [describe the function]
 * @modified:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum1 = 0;
        int sum2 = 0;
        int sum = 0;
        int i1 = 1;
        int i2 = 1;
        while (null != l1) {
            sum1 += l1.val * i1;
            i1 *= 10;
            l1 = l1.next;
        }
        while (null != l2) {
            sum1 += l2.val * i2;
            i2 *= 10;
            l2 = l2.next;
        }
        sum = sum1 + sum2;
        ListNode ret = null;
        while (sum != 0) {
            int val = sum % 10;
            sum /= 10;
            ListNode node = new ListNode(val);
            if (null == ret) {
                ret = node;
            } else {
                ListNode pre = ret;
                while (null != pre.next) {
                    pre = pre.next;
                }
                pre.next = node;
            }
        }
        if (null == ret) {
            ret = new ListNode(0);
        }
        return ret;
    }

}
