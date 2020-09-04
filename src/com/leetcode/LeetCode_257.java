package com.leetcode;

import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径(easy)
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 一、DFS，时间复杂度O(N^2)，空间复杂度O(N^2)
 * 二、BFS，时间复杂度O(N^2)，空间复杂度O(N^2)
 *
 * @author xing_seng
 * @date 2020/9/4
 */
public class LeetCode_257 {
    public List<String> binaryTreePathsDFS(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(root.val);
            if (root.left == null && root.right == null) {
                paths.add(pathSB.toString());
            } else {
                pathSB.append("->");
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }
}
