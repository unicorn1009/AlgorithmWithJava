package com.unicorn.niuke.动态规划;

import java.util.Map;

/**
 * <p>
 *      已知一个背包最多能容纳物体的体积为V
 *      现有n个物品
 *      第i个物品的体积为vi
 *      第i个物品的重量为wi
 *      求当前背包最多能装多大重量的物品
 * </p>
 * Created on 2021/04/27 18:58
 *
 * @author Unicorn
 */
public class 背包 {
    public static void main(String[] args) {
        int[][] vw = {{1,3}, {10,4}};
        System.out.println(knapsack(10, 2, vw));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算01背包问题的结果
     * @param V int整型 背包的体积
     * @param n int整型 物品的个数
     * @param vw int整型二维数组 第一维度为n,第二维度为2的二维数组,vw[i][0],vw[i][1]分别描述i+1个物品的vi,wi
     * @return int整型
     */
    public static int knapsack (int V, int n, int[][] vw) {
        int[][] dp = new int[n+1][V+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                // 判断是否可放
                if (vw[i-1][1] > j || j-vw[i-1][0] < 0){
                    // 放不下
                    dp[i][j] = dp[i-1][j];
                }else {
                    // 能放下
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-vw[i-1][0]]+vw[i-1][1]);
                }
            }
        }
        return dp[n][V];
    }
}
