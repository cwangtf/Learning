package com.leetcode;

import com.leetcode.utils.ListNode;

/**
 * @author xing_seng
 * @date 2020/7/4
 */
public class LeetCode_206_1 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
           ListNode nextTemp = curr.next;
           curr.next = pre;
           pre = curr;
           curr = nextTemp;
        }
        return pre;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode res = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
