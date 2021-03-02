package com.leetcode;

import com.leetcode.utils.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差(easy)
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * 中序遍历，时间复杂度O(n)，空间复杂度O(n)
 *
 * @author wangtf
 * @date 2020/10/12
 */
public class LeetCode_530 {
    int pre, ans;

    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != -1) {
            ans = Math.min(ans, (root.val - pre));
        }
        pre = root.val;
        dfs(root.right);
    }
}
