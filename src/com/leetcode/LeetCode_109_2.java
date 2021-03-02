package com.leetcode;

import com.leetcode.utils.ListNode;
import com.leetcode.utils.TreeNode;

/**
 * @author wangtf
 * @date 2020/8/18
 */
public class LeetCode_109_2 {
    ListNode globalNode;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        globalNode = head;
        int height = getLength(head);
        return buildTree(0, height - 1);
    }

    public int getLength(ListNode head) {
        int n = 0;
        while (head != null) {
            n++;
            head = head.next;
        }
        return n;
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode(0);
        root.left = buildTree(left, mid - 1);
        root.val = globalNode.val;
        globalNode = globalNode.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }
}
