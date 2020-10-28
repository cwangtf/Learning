package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. 独一无二的出现次数(easy)
 * https://leetcode-cn.com/problems/unique-number-of-occurrences/
 * 哈希表，时间复杂度O(N)，空间复杂度O(N)
 *
 * @author wangtf
 * @date 2020/10/28
 */
public class LeetCode_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occur = new HashMap<>();
        for (int x : arr) {
            occur.put(x, occur.getOrDefault(x, 0) + 1);
        }
        Set<Integer> times = new HashSet<>();
        for (Map.Entry<Integer, Integer> map : occur.entrySet()) {
            times.add(map.getValue());
        }
        return occur.size() == times.size();
    }
}
