package com.leetcode;

/**
 * 96. 不同的二叉搜索树(medium)
 * https://leetcode-cn.com/problems/unique-binary-search-trees
 * 动态规划
 * 初始状态，长度为1(只有根)或长度为0(空树)只有1中情况，即G(0)=1，G(1)=0
 * 状态转移方程，F(i, n)=G(i - 1) * G(n - i), i为根, n为长度
 *
 * @author xing_seng
 * @date 2020/7/15
 */
public class LeetCode_96 {
    /** 动态规划 */
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
