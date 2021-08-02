package com.unicorn.大厂热题;

import java.util.Arrays;

/**
 * <p>
 *     53. 最大子序和
 * </p>
 *
 * @author unicorn
 * @create 2021-07-20 11:06 下午
 */
public class 最大子序列和 {
    public int maxSubArray(int[] nums) {
        int x = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i],nums[i-1]+nums[i]);
            x = Math.max(x, nums[i]);
        }
        return x;
    }
}
