package com.leetcode;

import com.leetcode.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II(medium)
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 哈希表，时间复杂度O(n)，空间复杂度O(n)，快慢指针，时间复杂度O(n)，空间复杂度O(1)
 *
 * @author wangtf
 * @date 2020/10/10
 */
public class LeetCode_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            }
            visited.add(pos);
            pos = pos.next;
        }
        return null;
    }
}
