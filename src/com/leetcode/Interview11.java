package com.leetcode;

/**
 * 剑指 Offer 11. 旋转数组的最小数字(easy)
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 二分搜索，时间复杂度O(logN),最坏情况O(n);空间复杂度O(1)
 *
 * 类似题：
 * 154. 寻找旋转排序数组中的最小值 II(hard)
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii
 * 153. 寻找旋转排序数组中的最小值(medium)
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 *
 * @author wangtf
 * @date 2020/7/22
 */
public class Interview11 {
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            /** 这种写法是为了防止low和high特别大时溢出 */
            int pivot = low + ((high - low) >> 1);
            if (numbers[pivot] < numbers[high]) {
                /** 这里不加1是因为pivot可能是最小值 */
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                /** 加1是因为pivot不可能是最小值 */
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
