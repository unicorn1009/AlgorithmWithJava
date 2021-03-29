package com.unicorn.Leetcode;

/**
 * <p>
 *     63. 不同路径 II
 *     现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * </p>
 * Created on 2021/03/27 10:38
 *
 * @author Unicorn
 */
public class Solution0063 {
    public static void main(String[] args) {
        int[][] obs = {{0,0,1,0,0}};
        System.out.println(uniquePathsWithObstacles(obs));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        obstacleGrid[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i >= 1 && j >= 1)
                    obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                else if (j != 0)
                    obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i][j-1];
                else if (i != 0)
                    obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i-1][j];

            }
        }
        return obstacleGrid[row-1][col-1];
    }
}
