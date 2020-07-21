package com.leetcode;

/**
 * @author xing_seng
 * @date 2020/7/21
 */
public class LeetCode_167_1 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                ++left;
            } else {
                --right;
            }
        }
        return new int[]{-1, -1};
    }
}
