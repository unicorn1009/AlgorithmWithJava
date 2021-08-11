package com.unicorn.Leetcode;

/**
 * <p>
 *     334. 递增的三元子序列
 *     给你一个整数数组nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *     如果存在这样的三元组下标 (i, j, k)且满足 i < j < k ，使得nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * </p>
 * Created on 2021-8-4.
 *
 * @author Unicorn
 */
public class Solution0334 {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;
        // 记录下遍历到的最小值和次小值
        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= mid) {    // 出现了比min大且比mid小的数,更新mid
                mid = num;
            }
            else {
                // 一定出现了比mid更大的数
                return true;
            }
        }
        return false;
    }
}
