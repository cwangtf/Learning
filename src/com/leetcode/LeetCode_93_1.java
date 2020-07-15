package com.leetcode;

/**
 * @author xing_seng
 * @date 2020/7/15
 */
public class LeetCode_93_1 {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[n - j];
            }
        }
        return G[n];
    }
}
