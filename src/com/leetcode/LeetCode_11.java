package com.leetcode;

/**
 * 11. 盛最多水的容器(medium)
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 双指针，时间复杂度O(N)，空间复杂度O(1)
 *
 * @author wangtf
 * @date 2021/3/28
 */
public class LeetCode_11 {
    public int maxArea(int[] height) {
        int ans = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(area, ans);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
