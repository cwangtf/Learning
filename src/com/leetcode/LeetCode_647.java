package com.leetcode;

/**
 * 647. 回文子串(medium)
 * https://leetcode-cn.com/problems/palindromic-substrings
 * 一、中心扩展，时间复杂度O(n^2)，空间复杂度O(1)
 *
 * @author xing_seng
 * @date 2020/8/19
 */
public class LeetCode_647 {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = l + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
}
