package com.leetcode;

import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xing_seng
 * @date 2020/9/14
 */
public class LeetCode_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inOrder(node.left, res);
        res.add(node.val);
        inOrder(node.right, res);
    }
}
