package com.leetcode;

import com.leetcode.utils.ListNode;
import com.leetcode.utils.TreeNode;

/**
 * 109. 有序链表转换二叉搜索树(medium)
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 一、分治，时间复杂度O(nlogn)，空间复杂度O(logn)
 * 二、分治 + 中序遍历优化，时间复杂度O(n)，空间复杂度O(logn)
 *
 * @author wangtf
 * @date 2020/8/18
 */
public class LeetCode_109 {
    // 分治
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left, slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 分治 + 中序遍历优化
    ListNode globalHead;

    public TreeNode sortedListToBST1(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree1(0, length - 1);
    }

    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ++ret;
            head = head.next;
        }
        return ret;
    }

    public TreeNode buildTree1(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode(0);
        root.left = buildTree1(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree1(mid + 1, right);
        return root;
    }
}
