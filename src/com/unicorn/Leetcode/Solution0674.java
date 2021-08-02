package com.unicorn.Leetcode;

import java.util.Arrays;

/**
 * <p>
 *     最长连续递增序列
 * </p>
 * Created on 2021-7-27.
 *
 * @author Unicorn
 */
public class Solution0674 {
    public static void main(String[] args) {

    }
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int ans = 0;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }else {
                dp[i] = 1;
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
