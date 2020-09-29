package com.leetcode;

import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历(medium)
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 一、递归，时间复杂度O(n)，空间复杂度O(n)
 *
 * @author xing_seng
 * @date 2020/9/29
 */
public class LeetCode_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    public void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }
}
