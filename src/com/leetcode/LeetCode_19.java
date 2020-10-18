package com.leetcode;

import com.leetcode.utils.ListNode;

/**
 * 19. 删除链表的倒数第N个节点(medium)
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 快慢指针一次遍历，时间复杂度O(L)，空间复杂度O(1)
 *
 * @author wangtf
 * @date 2020/10/18
 */
public class LeetCode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumb = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dumb;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dumb.next;
    }
}
