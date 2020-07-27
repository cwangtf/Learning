package com.leetcode;

/**
 * 392. 判断子序列(easy)
 * https://leetcode-cn.com/problems/is-subsequence
 * 一、双指针，时间复杂度O(m+n)，空间复杂度O(1)
 * 二、动态规划
 *
 * @author xing_seng
 * @date 2020/7/27
 */
public class LeetCode_392 {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
