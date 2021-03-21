package com.leetcode;

/**
 * 459. 重复的子字符串(easy)
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 * 方法一：枚举，时间复杂度O(n^2)，空间复杂度O(1)
 * 方法二：字符串匹配
 * 方法三：KMP算法，时间复杂度O(n)，空间复杂度O(n)
 *
 * @author xing_seng
 * @date 2020/8/6
 */
public class LeetCode_336 {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
