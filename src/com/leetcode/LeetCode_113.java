package com.leetcode;

import com.leetcode.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II(medium)
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 一、DFS，时间复杂度O(N^2)，空间复杂度O(N)
 *
 * @author wangtf
 * @date 2020/9/26
 */
public class LeetCode_113 {
    List<List<Integer>> ret = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }

    public void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        path.offerLast(node.val);
        sum -= node.val;
        if (node.left == null && node.right == null && sum == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfs(node.left, sum);
        dfs(node.right, sum);
        path.pollLast();
    }
}
