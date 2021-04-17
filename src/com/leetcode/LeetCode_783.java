package com.leetcode;

import com.leetcode.utils.Tree;
import com.leetcode.utils.TreeNode;

/**
 * @author wangtf
 * @date 2021/4/13
 */
public class LeetCode_783 {
    int ans = Integer.MAX_VALUE;
    int pre = -1;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (pre != -1) {
            ans = Math.min(node.val - pre, ans);
        }
        pre = node.val;
        dfs(node.right);
    }

    public static void main(String[] args) {
        Integer[] data = {90,69,null,49,89,null,52};
        TreeNode[] nodes = new TreeNode[data.length];
        for(int i=0; i<data.length; i++){
            nodes[i] = data[i]==null ? null : new TreeNode(data[i].intValue());
        }
        Tree tree = new Tree();
        tree.createTreeAsLevel(nodes);
        LeetCode_783 t = new LeetCode_783();
        System.out.println(t.minDiffInBST(nodes[0]));
    }

}
