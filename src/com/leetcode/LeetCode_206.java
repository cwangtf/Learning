package com.leetcode;

import com.leetcode.utils.ListNode;
import com.leetcode.utils.ListNodeUtil;

/**
 * 206. 反转链表(easy)
 * https://leetcode-cn.com/problems/reverse-linked-list
 *
 * @author xing_seng
 * @date 2020/7/4
 */
public class LeetCode_206 {
    // 迭代
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 记录下一个节点
            ListNode nextTemp = curr.next;
            // 翻转
            curr.next = prev;
            // 向后移动
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // 递归
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode res = reverseList(head.next);
        // 当前节点下下节点指向当前节点
        head.next.next = head;
        head.next = null;
        return res;
    }

    public static void main(String[] args) {
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        ListNode listNode = listNodeUtil.createLinkedList(new int[]{1,2,3,4,5});
        LeetCode_206 leetCode206 = new LeetCode_206();
        System.out.println(leetCode206.reverseList(listNode));
    }
}
