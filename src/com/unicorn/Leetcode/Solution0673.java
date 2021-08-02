package com.unicorn.Leetcode;

/**
 * <p>
 *     673. 最长递增子序列的个数
 * </p>
 * Created on 2021-7-27.
 *
 * @author Unicorn
 */
public class Solution0673 {
    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }
    public static int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int ans = 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        int count = 0;
        for (int num : nums) {
            if (num == ans)
                count++;
        }
        return count;
    }
}

