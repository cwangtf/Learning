package com.leetcode;

/**
 * 329. 矩阵中的最长递增路径(hard)
 * https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
 * 一、记忆化深度优先搜索，时间复杂度O(mn)，空间复杂度O(mn)；二、动态规划
 *
 * @author xing_seng
 * @date 2020/7/26
 */
public class LeetCode_329 {
    public int[][] dirs = {{-1, 0}, {1, 0}, {0 , -1}, {0, 1}};
    public int rows, columns;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        // 记忆化数组定义
        int[][] memo = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; i < columns; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    /** 记忆化数组dfs处理 */
    public int dfs(int[][] matrix, int row, int column, int[][] memo) {
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        ++memo[row][column];
        for (int[] dir: dirs) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            /** 边界条件考虑清楚防止越界 */
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns &&
                    matrix[newRow][newColumn] > matrix[row][column]) {
                /** 此处还没想明白 */
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[row][column];
    }
}
