package com.leetcode;

/**
 * 1025. 除数博弈(easy)
 * https://leetcode-cn.com/problems/divisor-game
 * 智力题
 *
 * @author wangtf
 * @date 2020/7/24
 */
public class LeetCode_1025 {
    public boolean divisorGame(int N) {
        // 最佳状态
        return N % 2 == 0;
    }
}
