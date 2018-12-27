package com.dreamlee.leetcode.number203;

/**
 * @author: DreamLee
 * @date: Created on 23:10 2018/11/17
 * @description: 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @modified:
 */
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    ListNode(int[] arr) {
        if (null == arr || arr.length == 0)
            throw new IllegalArgumentException("数组不能为空");
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (null != cur) {
            sb.append(cur.val + "->");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        if (null == head)
            return null;
        ListNode ret = removeElements(head.next, val);
        head.next = ret;
        if (head.val == val)
            return ret;
        else
            return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (null == head)
            return null;
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,6,3,4,5,6};
        ListNode listNode = new ListNode(arr);
        Solution solution = new Solution();
        ListNode res = solution.removeElements(listNode, 6);
        System.out.println(res);
    }

}
