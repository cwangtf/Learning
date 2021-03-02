package com.leetcode;

import com.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangtf
 * @date 2020/7/8
 */
public class LeetCode_112_2 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode treeNode = queNode.poll();
            int temp = queVal.poll();
            if (treeNode.left == null && treeNode.right == null) {
                if (sum == temp) {
                    return true;
                }
                continue;
            }
            if (treeNode.left != null) {
                queNode.offer(treeNode.left);
                queVal.offer(temp + treeNode.left.val);
            }
            if (treeNode.right != null) {
                queNode.offer(treeNode.right);
                queVal.offer(temp + treeNode.right.val);
            }
        }
        return false;
    }
}
