package com.leetcode;

import com.leetcode.utils.TreeNode;

/**
 * @author xing_seng
 * @date 2020/8/5
 */
public class LeetCode_337_1 {
    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(treeNode.left);
        int[] r = dfs(treeNode.right);
        int selected = treeNode.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }
}
