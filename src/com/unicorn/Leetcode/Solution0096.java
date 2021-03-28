package com.unicorn.Leetcode;

/**
 * <p>
 *     96. 不同的二叉搜索树
 * </p>
 *
 * @author unicorn
 * @create 2021-03-23 10:00 下午
 */
public class Solution0096 {
    public static void main(String[] args) {
        System.out.println(new Solution0096().numTrees(6));
    }
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int x = 0;
            for (int j = 0; j < i ; j++) {
                x += (dp[j] * dp[i-j-1]);
            }
            dp[i] = x;
        }
        return dp[n];
    }


}
