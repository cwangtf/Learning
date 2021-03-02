package com.leetcode;

/**
 * 977. 有序数组的平方(easy)
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 一、直接排序，时间复杂度O(nlogn)，空间复杂度O(logn)
 * 二、优化的双指针，时间复杂度O(n)，空间复杂度O(1)
 *
 * @author wangtf
 * @date 2020/10/16
 */
public class LeetCode_977 {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0, j = n -1, pos = n -1; i<=j;) {
            if (A[i] * A[i] > A[j] * A[j]) {
                ans[pos] = A[i] * A[i];
                i++;
            } else {
                ans[pos] = A[j] * A[j];
                j--;
            }
            pos--;
        }
        return ans;
    }
}
