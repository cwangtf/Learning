package com.leetcode;

/**
 * 面试题 08.03. 魔术索引(easy)
 * https://leetcode-cn.com/problems/magic-index-lcci
 * 一、暴力法，时间复杂度O(n)，空间复杂度O(1)
 * 二、二分剪枝，最优O(logN)，最坏O(N),空间复杂度O(N)
 *
 * @author wangtf
 * @date 2020/7/31
 */
public class Interview08_03 {
    public int findMagicIndex(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    public int getAnswer(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        /** 优先寻找左边 */
        int leftAnswer = getAnswer(nums, left, mid - 1);
        if (leftAnswer != -1) {
            return leftAnswer;
        } else if (nums[mid] == mid) {
            /** 左侧没匹配到匹配当前值 */
            return mid;
        }
        /** 最后匹配右侧 */
        return getAnswer(nums, mid + 1, right);
    }
}
