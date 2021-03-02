package com.leetcode;

/**
 * 696. 计数二进制子串(easy)
 * https://leetcode-cn.com/problems/count-binary-substrings
 * 按字符分组，空间优化，只记录上一次值，时间复杂度O(n)，空间复杂度O(1)
 *
 * @author wangtf
 * @date 2020/8/10
 */
public class LeetCode_696 {
    public int countBinarySubstrings(String s) {
        int ptr = 0, n = s.length(), last = 0, ans = 0;
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
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
