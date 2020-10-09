package com.leetcode;

import com.leetcode.utils.ListNode;

/**
 * 141. 环形链表(easy)
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 快慢指针，时间复杂度O(n)，空间复杂度O(1)
 *
 * @author xing_seng
 * @date 2020/10/9
 */
public class LeetCode_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
