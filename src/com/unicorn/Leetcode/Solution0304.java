package com.unicorn.Leetcode;

/**
 * <p>
 *     304. 二维区域和检索 - 矩阵不可变
 * </p>
 * Created on 2021-7-21.
 *
 * @author Unicorn
 */
public class Solution0304 {
    public static void main(String[] args) {
        NumMatrix a= new NumMatrix(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(a.sumRegion(0,1,4,3));
        System.out.println(a.sumRegion(1,0,3,2));
        System.out.println(a.sumRegion(0,0,2,4));
    }


    static class NumMatrix {

        private int[][] matrix;

        public NumMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    int x = matrix[i][j];
                    if (i - 1 >= 0){
                        x += matrix[i-1][j];
                    }
                    if (j-1>=0){
                        x += (matrix[i][j-1]);
                        if (i-1>=0){
                            x -= matrix[i-1][j-1];
                        }
                    }
                    matrix[i][j] = x;
                    System.out.print(x+", ");
                }
                System.out.println();
            }
            this.matrix = matrix;

        }

        public int sumRegion(int x1, int y1, int x2, int y2) {
            if (x1-1>=0 && y1-1 >= 0)
                return matrix[x2][y2]+matrix[x1-1][y1-1]-matrix[x1-1][y2]-matrix[x2][y1-1];
            else if (x1-1>=0){
                return matrix[x2][y2]-matrix[x1-1][y2];
            }else if (y1-1>=0){
                return matrix[x2][y2]-matrix[x2][y1-1];
            }else {
                return matrix[x2][y2];
            }
        }
    }
}
