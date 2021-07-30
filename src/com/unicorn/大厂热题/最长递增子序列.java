package com.unicorn.大厂热题;

/**
 * <p>
 * </p>
 * Created on 2021-7-27.
 *
 * @author Unicorn
 */
public class 最长递增子序列 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1,3,5,4,7}));
    }
    public static int lengthOfLIS(int[] nums) {
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
        return ans;
    }
}
