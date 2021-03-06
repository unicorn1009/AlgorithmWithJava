package com.unicorn.Leetcode;

/**
 * <p>
 *     53. 最大子序和
 *     给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * </p>
 * Created on 2021/3/6.
 *
 * @author Unicorn
 */
public class Solution0053 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, -1, -3, -4}));

    }

    // 动态规划
    public static int maxSubArray(int[] nums) {
        // nums[i]记为以i结尾的子序列的最大和
        // 因此, 已知nums[i-1]的情况下, 判断nums[i-1]是否小于0, 若是, 则丢弃
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > 0){
                nums[i] += nums[i-1];
            }
            if (nums[i] > maxSum){
                maxSum = nums[i];
            }
        }
        return maxSum;
    }
}
