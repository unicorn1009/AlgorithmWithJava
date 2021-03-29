package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     62. 不同路径
 *     一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 *      机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 *      问总共有多少条不同的路径？

 * </p>
 * Created on 2021/03/22 10:18
 *
 * @author Unicorn
 */
public class Solution0062 {

    // 动归
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }


    // 回溯 超时
    int ans;
    public int uniquePaths(int m, int n) {
        int[] site = new int[]{1, 1};
        dfs(m, n, site);
        return ans;
    }

    private void dfs(int m, int n, int[] site) {
        if (site[0] == m && site[1] == n) {
            // 到达目的地
            ans++;
            return;
        }

        if (site[0] < m) {
            // 往下走
            site[0] = site[0] + 1;
            dfs(m, n, site);
            site[0] = site[0] - 1;
        }

        if (site[1] < n) {
            // 往右走
            site[1] = site[1] + 1;
            dfs(m, n, site);
            site[1] = site[1] - 1;
        }
    }
}
