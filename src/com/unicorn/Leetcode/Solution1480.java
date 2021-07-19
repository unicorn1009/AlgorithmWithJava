package com.unicorn.Leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * <p>
 *     1480. 一维数组的动态和
 * </p>
 *
 * @author unicorn
 * @create 2021-04-07 11:07 下午
 */
public class Solution1480 {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;
    }
}
