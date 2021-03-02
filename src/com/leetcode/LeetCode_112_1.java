package com.leetcode;

import com.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangtf
 * @date 2020/7/7
 */
public class LeetCode_112_1 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode node = queNode.poll();
            int temp = queVal.poll();
            if (node.left == null && node.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                queNode.offer(node.left);
                queVal.offer(node.left.val + temp);
            }
            if (node.right != null) {
                queNode.offer(node.right);
                queVal.offer(node.right.val + temp);
            }
        }
        return false;
    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);
    }
}
