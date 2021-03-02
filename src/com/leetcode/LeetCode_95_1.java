package com.leetcode;

import com.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangtf
 * @date 2020/7/21
 */
public class LeetCode_95_1 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTree(1, n);
    }

    public List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; ++i) {
            List<TreeNode> leftTrees = generateTree(start, i - 1);
            List<TreeNode> rightTrees = generateTree(i + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode current = new TreeNode(i);
                    current.left = left;
                    current.right = right;
                    allTrees.add(current);
                }
            }
        }
        return allTrees;
    }
}
