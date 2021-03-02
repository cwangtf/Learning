package com.leetcode;

import com.leetcode.utils.ListNode;
import com.leetcode.utils.TreeNode;

/**
 * @author wangtf
 * @date 2020/8/18
 */
public class LeetCode_109_1 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode curNode = new TreeNode(mid.val);
        curNode.left = buildTree(left, mid);
        curNode.right = buildTree(mid.next, right);
        return curNode;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left, slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
