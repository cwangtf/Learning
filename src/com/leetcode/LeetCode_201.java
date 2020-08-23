package com.leetcode;

/**
 * 201. 数字范围按位与(medium)
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 * 一、位移，时间复杂度O(logN)，空间复杂度O(1)
 * 二、Brian Kernighan 算法，时间复杂度O(logN)，空间复杂度O(1)
 *
 * @author xing_seng
 * @date 2020/8/23
 */
public class LeetCode_201 {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }

    public int rangeBitwiseAnd1(int m, int n) {
        while (m < n) {
            n = n & (n -1);
        }
        return n;
    }
}
