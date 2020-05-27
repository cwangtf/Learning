package com.leetcode;

import com.xingseng.utils.Tree;
import com.xingseng.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author xing_seng
 * @date 2020/5/27
 */
public class LeetCode_102_1 {

    List<List<Integer>> res = new ArrayList<>();

    /**
     * 递归
     *
     * @param node
     * @param level
     */
    public void helper(TreeNode node, int level) {
        // 新开一层，此处注意
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        helper(root, 0);
        return res;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        // 此处判空
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                // 放到循环里
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] data = {5,3,6,2,4,null,7};
        TreeNode[] nodes = new TreeNode[data.length];
        for(int i=0; i<data.length; i++){
            nodes[i] = data[i]==null ? null : new TreeNode(data[i].intValue());
        }
        Tree tree = new Tree();
        tree.createTreeAsLevel(nodes);
        LeetCode_102_1 t = new LeetCode_102_1();
        t.levelOrder1(nodes[0]);
    }

}
