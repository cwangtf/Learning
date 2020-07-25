package com.leetcode;

import com.leetcode.utils.ListNode;
import com.leetcode.utils.ListNodeUtil;

/**
 * 160. 相交链表(easy)
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 一、暴力法(嵌套循环两个链表，判断是否有重复元素)
 * 二、hash表优化(将第一个链表用hash存起来，判断第二个是否命中)
 * 三、双指针法()
 *
 * @author xing_seng
 * @date 2020/7/25
 */
public class LeetCode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA, b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        ListNodeUtil util = new ListNodeUtil();
        ListNode a = util.createLinkedList(new int[]{2, 6, 4});
        ListNode b = util.createLinkedList(new int[]{1, 5});
        LeetCode_160 leetCode160 = new LeetCode_160();
        ListNode res = leetCode160.getIntersectionNode(a, b);
        System.out.println(res);
    }
}
