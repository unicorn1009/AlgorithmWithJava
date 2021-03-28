package com.unicorn.jzoffer;

/**
 * <p>
 *     剑指 Offer 47. 礼物的最大价值
 *     在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 *     你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 *     给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * </p>
 *
 * @author unicorn
 * @create 2021-03-19 10:08 下午
 */
public class JZ047 {


    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1}, {1,5,1}, {4,2,1}};
        System.out.println(new JZ047().maxValue1(arr));
    }

    // 动规
    public int maxValue1(int[][] grid) {
        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        if (col == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) continue;
                // 走到i,j位置的最大收益
                // 等于从上面走下来的和从左边走过来的中的较大者
                if (i == 0) {
                    // 第一行, 只能从左边走过来
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                    continue;
                }
                if (j == 0){
                    // 第一列, 只能从上面走下来
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                    continue;
                }
                dp[i][j] = grid[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[row-1][col-1];
    }

    // 回溯 超时
    int ans;
    public int maxValue(int[][] grid) {

        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        if (col == 0) return 0;
        int curValue = grid[0][0];
        int[] site = new int[]{0, 0};
        dfs(grid, curValue, site, row, col);
        return ans;
    }

    private void dfs(int[][] grid, int curValue, int[] site, int row, int col) {
        if (site[0] == row-1 && site[1] == col-1){
            // 到达右下角
            ans = Math.max(ans, curValue);
            return;
        }

        // 没走到右下角, 可往右或往下走一格子
        if (site[0] < row-1){
            // 可以往下走,行+1 列不变
            site[0] = site[0] + 1;
            dfs(grid, curValue+grid[site[0]][site[1]], site, row, col);
            site[0] = site[0] - 1;
        }

        if (site[1] < col-1){
            // 可以往右走,列+1 行不变
            site[1] = site[1] + 1;
            dfs(grid, curValue+grid[site[0]][site[1]], site, row, col);
            site[1] = site[1] - 1;
        }

    }


}
