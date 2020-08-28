package com.leetcode;

/**
 * 657. 机器人能否返回原点(easy)
 * https://leetcode-cn.com/problems/robot-return-to-origin
 * 模拟，时间复杂度O(N)，空间复杂度O(1)
 *
 * @author xing_seng
 * @date 2020/8/28
 */
public class LeetCode_657 {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        int length = moves.length();
        for (int i = 0; i < length; i++) {
            char move = moves.charAt(i);
            if (move == 'U') {
                y--;
            } else if (move == 'D') {
                y++;
            } else if (move == 'R') {
                x++;
            } else if (move == 'L') {
                x--;
            }
        }
        return x == 0 && y ==0;
    }
}
