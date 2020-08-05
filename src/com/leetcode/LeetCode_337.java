package com.leetcode;

import com.leetcode.utils.TreeNode;

/**
 * 337. 打家劫舍 III(medium)
 * https://leetcode-cn.com/problems/house-robber-iii
 * 动态规划
 * f代表选择，g代表未选，o代表当前节点，l左子节点，r右子节点
 * f(o) = g(l) + g(r)
 * g(0) = max{f(l), g(l)} + max{f(r), g(r)}
 *
 * @author xing_seng
 * @date 2020/8/5
 */
public class LeetCode_337 {
    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0 , 0};
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int selected = node.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }
}
