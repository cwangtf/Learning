package com.leetcode;

/**
 * 63. 不同路径 II(medium)
 * https://leetcode-cn.com/problems/unique-paths-ii
 * 动态规划
 * 状态转移方程 f(i, j) = 0,u(i, j) = 0或f(i, j) = f(i - 1, j) + f(i, j - 1), u(i, j) ≠ 0
 * 滚动数组思想
 * 动规分类：一、求最优解类（递推性质叫最优子结构），典型问题是背包问题；二、计数类，统计方案数问题（此题）
 *
 * @author wangtf
 * @date 2020/7/6
 */
public class LeetCode_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[m - 1];
    }
}
