package com.leetcode;

import java.util.Stack;

/**
 * 32. 最长有效括号(hard)
 * https://leetcode-cn.com/problems/longest-valid-parentheses
 * 动规、栈
 *
 * @author xing_seng
 * @date 2020/7/4
 */
public class LeetCode_32 {
    // 栈
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        LeetCode_32 leetCode32 = new LeetCode_32();
        System.out.println(leetCode32.longestValidParentheses("())((())"));
        System.out.println(leetCode32.longestValidParentheses("))("));
        System.out.println(leetCode32.longestValidParentheses("(()()()"));
    }
}
