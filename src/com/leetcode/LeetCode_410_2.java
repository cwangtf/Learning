package com.leetcode;

/**
 * @author xing_seng
 * @date 2020/7/26
 */
public class LeetCode_410_2 {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0;
        for (int num : nums) {
            right += num;
            if (left < num) {
                left = num;
            }
        }
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            // 此处逻辑要再品一品
            if (check(nums, mid, m)) {
                // 这里
                right = mid;
            } else {
                // 这里
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int x, int m) {
        int sum = 0, cnt = 1;
        for (int num : nums) {
            if (sum > x) {
                cnt++;
                sum = num;
            } else {
                sum += num;
            }
        }
        return cnt <= m;
    }
}
