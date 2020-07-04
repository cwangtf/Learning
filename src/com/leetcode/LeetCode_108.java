package com.leetcode;

import com.leetcode.utils.TreeNode;

import java.util.Random;

/**
 * 108. 将有序数组转换为二叉搜索树(easy)
 * 中序遍历
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * @author xing_seng
 * @date 2020/7/3
 */
public class LeetCode_108 {
    Random rand = new Random();
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + rand.nextInt(2)) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = helper(nums, left, mid);
        treeNode.right = helper(nums, mid + 1, right);
        return treeNode;
    }
}
