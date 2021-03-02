package com.leetcode;

/**
 * 面试题 16.11. 跳水板(easy)
 * https://leetcode-cn.com/problems/diving-board-lcci
 * 数学归纳(时间复杂度O(k)，空间复杂度O(1))
 *
 * @author wangtf
 * @date 2020/7/8
 */
public class Interview16_11 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] lengths = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            lengths[i] = shorter * (k - 1) + longer * i;
        }
        return lengths;
    }
}
