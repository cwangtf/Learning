package com.leetcode;

/**
 * @author xing_seng
 * @date 2020/8/19
 */
public class LeetCode_647_1 {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = l + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r))  {
                // 此处是--l,++r
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
}
