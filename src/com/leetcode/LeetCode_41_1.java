package com.leetcode;

/**
 * 41. 缺失的第一个正数
 *
 * @author xing_seng
 * @date 2020/6/27
 */
public class LeetCode_41_1 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            // 此数在有效范围内且要交换的位置的数不对时
            while (nums[i] > 0 && nums[i] <=len && nums[nums[i] - 1] != nums[i]) {
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
        LeetCode_41_1 leetCode411 = new LeetCode_41_1();
        int res = leetCode411.firstMissingPositive(new int[]{3,4,-1,1});
        System.out.println(res);
    }
}
