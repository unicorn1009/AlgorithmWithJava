package com.unicorn.Leetcode;

import java.util.Arrays;

/**
 * <p>
 *     73. 矩阵置零
 * </p>
 *
 * @author unicorn
 * @create 2021-03-21 10:34 下午
 */
public class Solution0073 {
    public static void main(String[] args) {
        int[][] mat = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new Solution0073().setZeroes(mat);
        for (int[] ints : mat) {
            System.out.println(Arrays.toString(ints));
        }
    }
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean oneRow = false;
        boolean oneCol = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0){
                oneCol = true;
                break;
            }
        }
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0){
                oneRow = true;
                break;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // 只看第一行
        for (int j = 1; j < col; j++) {
            if (matrix[0][j] == 0){
                // j列置0
                for (int k = 0; k < row; k++) {
                    matrix[k][j] = 0;
                }
            }
        }
        // 只看第一列
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0){
                // i行置0
                for (int k = 0; k < col; k++) {
                    matrix[i][k] = 0;
                }
            }
        }


        if (oneCol){
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }

        if (oneRow){
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
