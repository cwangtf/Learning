package com.leetcode;

import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历(medium)
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 一、递归，时间复杂度O(n)，空间复杂度O(n)
 * 二、迭代，时间复杂度O(n)，空间复杂度O(n)
 * 三、Morris遍历，时间复杂度O(n)，空间复杂度O(1)
 *
 * @author wangtf
 * @date 2020/10/27
 */
public class LeetCode_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) {
            return;
        }
        res.add(treeNode.val);
        preorder(treeNode.left, res);
        preorder(treeNode.right, res);
    }
}
