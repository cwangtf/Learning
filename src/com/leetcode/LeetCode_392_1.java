package com.leetcode;

/**
 * @author xing_seng
 * @date 2020/7/27
 */
public class LeetCode_392_1 {
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