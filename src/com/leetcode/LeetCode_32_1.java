package com.leetcode;

import java.util.Stack;

/**
 * @author wangtf
 * @date 2020/7/4
 */
public class LeetCode_32_1 {
    public int longestValidParentheses(String s) {
        int max = 0;
        if (s == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
