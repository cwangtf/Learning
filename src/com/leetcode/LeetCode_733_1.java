package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangtf
 * @date 2020/8/16
 */
public class LeetCode_733_1 {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }
        int m = image.length, n = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = s[0] + dx[i], y = s[1] + dy[i];
                if (x >=0 && x < m && y >= 0 && y < n && image[x][y] == currColor) {
                    queue.offer(new int[]{x, y});
                    image[x][y] = newColor;
                }
            }
        }
        return image;
    }

    public int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor != newColor) {
            dfs(image, sr, sc, currColor, newColor);
        }
        return image;
    }

    public void dfs(int[][] image, int x, int y, int currColor, int newColor) {
        if (image[x][y] == currColor) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < image.length && ny >= 0 && ny < image[0].length) {
                    dfs(image, nx, ny, currColor, newColor);
                }
            }
        }
    }
}
