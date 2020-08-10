package com.leetcode;

/**
 * @author xing_seng
 * @date 2020/8/10
 */
public class LeetCode_696_1 {
    public int countBinarySubstrings(String s) {
        int ptr = 0, n = s.length(), ans = 0, last = 0;
        while (ptr < n) {
            int count = 0;
            char c = s.charAt(ptr);
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            ans += Math.min(count, last);
            last = count;
        }
        return ans;
    }

}
