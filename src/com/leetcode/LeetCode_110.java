package com.leetcode;

import com.leetcode.utils.Tree;
import com.leetcode.utils.TreeNode;

/**
 * @author xing_seng
 * @date 2020/8/17
 */
public class LeetCode_110 {
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    public boolean isBalanced2(TreeNode root) {
        return height1(root) >= 0;
    }

    public int height1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height1(root.left);
        int rightHeight = height1(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        Integer[] data = {3,9,20,null,null,15,7};
        TreeNode[] nodes = new TreeNode[data.length];
        for(int i=0; i<data.length; i++){
            nodes[i] = data[i]==null ? null : new TreeNode(data[i].intValue());
        }
        Tree tree = new Tree();
        tree.createTreeAsLevel(nodes);
        LeetCode_110 leetCode110 = new LeetCode_110();
        System.out.println(leetCode110.isBalanced2(nodes[0]));
    }
}
