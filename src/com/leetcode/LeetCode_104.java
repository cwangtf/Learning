package com.leetcode;

import com.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度(easy)
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 一、DFS递归，时间复杂度O(n),空间复杂度O(n)
 * 二、BFS，时间复杂度O(n),空间复杂度O(n)
 *
 * @author xing_seng
 * @date 2020/7/28
 */
public class LeetCode_104 {
    /** DFS */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /** BFS */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            // 获取当前层节点个数
            int size = queue.size();
            while (size > 0) {
                // 遍历当前层节点
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                // 遍历一个size-1
                size--;
            }
            // 遍历完一层加1
            ans++;
        }
        return ans;
    }
}
