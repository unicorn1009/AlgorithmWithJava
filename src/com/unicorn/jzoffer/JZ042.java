package com.unicorn.jzoffer;

/**
 * <p>
 *     剑指 Offer 42. 连续子数组的最大和
 *     输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * </p>
 * Created on 2021/3/18.
 *
 * @author Unicorn
 */
public class JZ042 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2}));
    }
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 如果累加和比当前自身还小, 则放弃之前的累加和
            sum += nums[i];
            if (sum < nums[i]){
                sum = nums[i];
            }
            if (sum > maxSum)
                maxSum = sum;
        }

        return maxSum;
    }
}
