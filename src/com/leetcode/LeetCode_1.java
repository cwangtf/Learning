package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和(easy)
 * https://leetcode-cn.com/problems/two-sum/
 * 哈希表，时间复杂度O(N)，空间复杂度O(N)
 *
 * @author wangtf
 * @date 2020/10/3
 */
public class LeetCode_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
