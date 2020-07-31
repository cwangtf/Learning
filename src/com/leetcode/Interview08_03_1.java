package com.leetcode;

/**
 * @author xing_seng
 * @date 2020/7/31
 */
public class Interview08_03_1 {
    public int findMagicIndex(int[] nums) {
        return getAnswer(nums, 0 , nums.length - 1);
    }

    public int getAnswer(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        int leftAnswer = getAnswer(nums, left, mid - 1);
        if (leftAnswer != -1) {
            return leftAnswer;
        } else if (mid == nums[mid]) {
            return mid;
        }
        return getAnswer(nums, mid + 1, right);
    }
}
