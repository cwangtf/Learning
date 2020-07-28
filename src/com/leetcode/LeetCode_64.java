package com.leetcode;

/**
 * 64. 最小路径和(medium)
 * https://leetcode-cn.com/problems/minimum-path-sum
 * 动态规划
 * 状态转移方程
 * i > 0 且 j = 0时,dp[i][0] = dp[i - 1][0] + grid[i][0];
 * i = 0 且 j > 0时,dp[0][j] = dp[0][j - 1] + grid[0][j];
 * i > 0 且 j > 0时,dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
 *
 * @author xing_seng
 * @date 2020/7/23
 */
public class LeetCode_64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j -1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }
}