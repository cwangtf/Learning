package com.leetcode;

/**
 * 35. 搜索插入位置(easy)
 * https://leetcode-cn.com/problems/search-insert-position
 * 二分查找
 * 时间复杂度O(logN),空间复杂度O(1)
 *
 * @author wangtf
 * @date 2020/7/17
 */
public class LeetCode_35 {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
