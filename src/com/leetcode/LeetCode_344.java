package com.leetcode;

/**
 * 344. 反转字符串(easy)
 * https://leetcode-cn.com/problems/reverse-string/
 * 双指针，时间内复杂度O(n)，空间复杂度O(1)
 *
 * @author xing_seng
 * @date 2020/10/8
 */
public class LeetCode_344 {
    public void reverseString(char[] s) {
        int length = s.length;
        for (int left = 0, right = length - 1; left < right; left++, right--) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}
