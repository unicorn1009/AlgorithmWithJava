package com.unicorn.vivo.bs0617;

import java.util.Map;

/**
 * <p>
 *     一货轮最大载重量为C, 有N个集装箱, 0 - n-1, 每个箱的重量为W(i), 价值为V(i), 求在载重范围内, 如何选择集装箱使得价值最大
 *     返回最大总价值
 * </p>
 * Created on 2021/6/17.
 *
 * @author Unicorn
 */
public class 背包问题 {
    public static void main(String[] args) {
        System.out.println(maxValue(5, new int[]{1, 2, 3}, new int[]{6, 10, 12}));
    }

    public static int maxValue(int C, int[] weights, int[] values){
        int n = weights.length;
        // dp[i][j]表示将前i件物品装进限重为j的背包可以获得的最大价值
        int[][] dp = new int[n+1][C+1];
        // base case
        for (int x = 0; x <= C; x++) {
            dp[0][x] = 0;
        }
        for (int x = 0; x < n; x++) {
            dp[x][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= C; j++) {
                if (j - weights[i-1] >= 0){
                    dp[i][j] = Math.max(dp[i-1][j-weights[i-1]]+values[i-1], dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][C];

    }
}
