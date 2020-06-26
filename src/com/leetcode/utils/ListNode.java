package com.leetcode.utils;

/**
 * @author xing_seng
 * @date 2020/6/26
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String s = "";
        ListNode current = this;
        while ( current != null ) {
            s = s + " " + current.val;
            current = current.next;
        }
        return s;
    }
}
