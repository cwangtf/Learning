package com.leetcode;

/**
 * 41. 缺失的第一个正数
 *
 * @author wangtf
 * @date 2020/6/28
 */
public class LeetCode_41_2 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 1;
        }
        for (int i = 0; i < len; i++) {
            // 此处是while,一直交换直到不满足条件为止
            while (nums[i] > 0 && nums[i] < len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        LeetCode_41_2 leetCode412 = new LeetCode_41_2();
        System.out.println(leetCode412.firstMissingPositive(new int[]{-1,4,2,1,9,10}));
    }
}
