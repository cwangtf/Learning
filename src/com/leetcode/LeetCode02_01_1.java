package com.leetcode;

import com.leetcode.utils.ListNode;
import com.leetcode.utils.ListNodeUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xing_seng
 * @date 2020/6/26
 */
public class LeetCode02_01_1 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> occurred = new HashSet<>();
        occurred.add(head.val);
        ListNode pos = head;
        // 枚举前驱节点
        while (pos.next != null) {
            // 当前待删除节点
            ListNode cur = pos.next;
            if (occurred.add(cur.val)) {
                pos = pos.next;
            } else {
                // 将下一节点置为下下节点
                pos.next = pos.next.next;
            }
        }
        // ？
        pos.next = null;
        // return head 和 pos 区别，lc上执行结果不一样
        return head;
    }

    public static void main(String[] args) {
        ListNodeUtil util = new ListNodeUtil();
        ListNode l = util.createLinkedList(new int[]{1, 2, 3, 3, 2, 1});
        LeetCode02_01 leetCode0201 = new LeetCode02_01();
        ListNode res = leetCode0201.removeDuplicateNodes(l);
        System.out.println(res);
    }
}
