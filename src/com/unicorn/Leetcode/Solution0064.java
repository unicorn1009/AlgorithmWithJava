package com.unicorn.Leetcode;

/**
 * <p>
 *     请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *     每次只能向下或者向右移动一步。
 * </p>
 *
 * @author unicorn
 * @create 2021-07-22 12:18 下午
 */
public class Solution0064 {
    public int minPathSum(int[][] grid) {
        // 动规
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j > 0){    // 第一行
                    grid[i][j] = grid[i][j-1]+grid[i][j];
                }else if (j == 0 && i > 0){  // 第一列
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                }else if (i > 0){
                    grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1])+grid[i][j];
                }
            }
        }
        return grid[row-1][col-1];
    }
}
