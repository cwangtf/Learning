package com.leetcode;

import com.leetcode.utils.TreeNode;

/**
 * 129. 求根到叶子节点数字之和(medium)
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * DFS，时间复杂度O(n)，空间复杂度O(n)
 * BFS，时间复杂度O(n)，空间复杂度O(n)
 *
 * @author wangtf
 * @date 2020/10/30
 */
public class LeetCode_129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode treeNode, int prevSum) {
        if (treeNode == null) {
            return 0;
        }
        int sum = prevSum * 10 + treeNode.val;
        if (treeNode.left == null && treeNode.right == null) {
            return sum;
        } else {
            return dfs(treeNode.left, sum) + dfs(treeNode.right, sum);
        }
    }
}
