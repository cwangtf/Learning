package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * @author xing_seng
 * @date 2020/6/30
 */
public class CQueue1 {
    Deque<Integer> stack1, stack2;

    public CQueue1() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            int deleteItem = stack2.pop();
            return deleteItem;
        }
    }
}
