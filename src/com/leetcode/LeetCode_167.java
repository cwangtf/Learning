package com.leetcode;

/**
 * 167. 两数之和 II - 输入有序数组(easy)
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 一、二分查找；二、双指针
 * 双指针类似题:
 * 11. 盛最多水的容器 https://leetcode-cn.com/problems/container-with-most-water
 * 15. 三数之和 https://leetcode-cn.com/problems/3sum
 * 26. 删除排序数组中的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 *
 * @author wangtf
 * @date 2020/7/20
 */
public class LeetCode_167 {
    /** 二分查找 */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            // 避免重复寻找，寻找第二个数时，只在第一个数右边查找
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = ((high - low) >> 1) + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    /** 双指针 */
    public int[] twoSum1(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                -- high;
            }
        }
        return new int[]{-1, -1};
    }
}
