package com.leetcode;

/**
 * @author xing_seng
 * @date 2020/7/29
 */
public class LeetCode_392_2 {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }
}
