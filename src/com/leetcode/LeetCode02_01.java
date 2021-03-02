package com.leetcode;

import com.leetcode.utils.ListNode;
import com.leetcode.utils.ListNodeUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 移除重复节点(easy)
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 哈希表
 *
 * @author wangtf
 * @date 2020/6/26
 */
public class LeetCode02_01 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> occurred = new HashSet<>();
        occurred.add(head.val);
        ListNode pos = head;
        while (pos.next != null) {
            ListNode cur = pos.next;
            if (occurred.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNodeUtil util = new ListNodeUtil();
        ListNode l = util.createLinkedList(new int[]{1, 1, 1, 1, 2});
        LeetCode02_01 leetCode0201 = new LeetCode02_01();
        ListNode res = leetCode0201.removeDuplicateNodes(l);
        System.out.println(res);
    }
}
