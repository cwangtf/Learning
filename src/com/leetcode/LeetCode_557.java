package com.leetcode;

/**
 * 557. 反转字符串中的单词 III(easy)
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * 使用额外空间，时间复杂度O(N)，空间复杂度O(N)
 *
 * @author xing_seng
 * @date 2020/8/30
 */
public class LeetCode_557 {
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        int length = s.length(), i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int j = start; j < i; j++) {
                sb.append(s.charAt(start + i - 1 - j));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
