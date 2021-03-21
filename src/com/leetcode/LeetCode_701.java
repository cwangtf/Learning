package com.leetcode;

import com.leetcode.utils.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作(medium)
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/solution/
 * 一、模拟，时间复杂度O(N)，空间复杂度O(1)
 *
 * @author xing_seng
 * @date 2020/9/30
 */
public class LeetCode_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode pos = root;
        while (pos != null) {
            if (val < pos.val) {
                if (pos.left == null) {
                    pos.left = new TreeNode(val);
                    break;
                } else {
                    pos = pos.left;
                }
            } else {
                if (pos.right == null) {
                    pos.right = new TreeNode(val);
                    break;
                } else {
                    pos = pos.right;
                }
            }
        }
        return root;
    }
}
