package com.leetcode;

import com.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度(easy)
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 一、DFS，时间复杂度O(N)，空间复杂度O(H)
 * 二、BFS，时间复杂度O(N)，空间复杂度O(N)
 *
 * @author xing_seng
 * @date 2020/8/21
 */
public class LeetCode_111 {
    public int minDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepthDFS(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepthDFS(root.right), minDepth);
        }
        return minDepth + 1;
    }

    class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int minDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }
        return 0;
    }
}
