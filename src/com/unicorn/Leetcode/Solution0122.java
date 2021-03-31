package com.unicorn.Leetcode;

/**
 * <p>
 *     122. 买卖股票的最佳时机 II
 *     设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * </p>
 * Created on 2021/03/31 20:43
 *
 * @author Unicorn
 */
public class Solution0122 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7}));
    }
    public static int maxProfit(int[] prices) {
        int days = prices.length;
        int[][] dp = new int[days][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < days; i++) {
            dp[i][0] = Math.max(dp[i-1][1] + prices[i], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[days-1][0];
    }
}
