package com.leetcode;

import com.leetcode.utils.ListNode;

/**
 * 24. 两两交换链表中的节点(medium)
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 一、递归，时间复杂度O(n)，空间复杂度O(n)
 *
 * @author xing_seng
 * @date 2020/10/13
 */
public class LeetCode_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
