package com.leetcode;

/**
 * 122. 买卖股票的最佳时机 II(easy)
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 一、动态规划，时间复杂度O(n)，空间复杂度O(n)
 * 二、贪心，时间复杂度O(n)，空间复杂度O(1)
 *
 * @author wangtf
 * @date 2020/11/8
 */
public class LeetCode_122 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
