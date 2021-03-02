package com.leetcode;

import com.leetcode.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层级遍历(medium)
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 *
 * @author wangtf
 * @date 2020/5/26
 */
public class LeetCode_102 {
    List<List<Integer>> levels = new ArrayList<>();

    /**
     * DFS递归
     *
     * @param node 节点
     * @param level 当前层
     */
    public void helper(TreeNode node, int level) {
        // 新开一层
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(node.val);

        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }

    /**
     * DFS递归
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }

    /**
     * BFS(队列)
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

}
