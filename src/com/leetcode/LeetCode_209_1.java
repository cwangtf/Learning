package com.leetcode;

/**
 * 209. 长度最小的子数组(双指针)
 *
 * @author xing_seng
 * @date 2020/6/28
 */
public class LeetCode_209_1 {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < len) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        LeetCode_209_1 leetCode2091 = new LeetCode_209_1();
        System.out.println(leetCode2091.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
