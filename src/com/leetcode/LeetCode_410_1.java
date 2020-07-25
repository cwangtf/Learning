package com.leetcode;

/**
 * @author xing_seng
 * @date 2020/7/25
 */
public class LeetCode_410_1 {
    public int splitArray(int[] nums, int m) {
        int left = 0,right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }
        while (left < right) {
            // 此处>>1要括号，不让会超时
            int mid = ((right - left) >> 1) + left;
            if (check(nums, mid, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int x, int m) {
        int sum = 0, cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            // 如果总和超出了限制，新开一个，将总和初始化
            if (sum + nums[i] > x) {
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return cnt <= m;
    }
}
