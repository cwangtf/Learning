package com.leetcode;

import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xing_seng
 * @date 2020/9/4
 */
public class LeetCode_257_1 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPath(root, "", paths);
        return paths;
    }

    public void constructPath(TreeNode root, String val, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(val);
            pathSB.append(root.val);
            if (root.left == null && root.right == null) {
                paths.add(pathSB.toString());
            } else {
                pathSB.append("->");
                constructPath(root.left, pathSB.toString(), paths);
                constructPath(root.right, pathSB.toString(), paths);
            }
        }
    }
}
