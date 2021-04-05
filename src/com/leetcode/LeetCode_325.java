package com.leetcode;

import java.util.HashMap;

/**
 * @author wangtf
 * @date 2021/3/28
 */
public class LeetCode_325 {
    public static int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k) max = i + 1;
            else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 1, 1, 1};
        System.out.println(maxSubArrayLen(nums, 2));
    }
}
