package com.unicorn.笔试.虾皮.秋招2022;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-07-19 3:36 下午
 */
public class 杨辉三角 {
    public static void main(String[] args) {
        System.out.println(getValue(3, 2));
    }
    public static int getValue(int rowIndex, int columnIndex) {
        // write code here
        int[][] ans = new int[rowIndex+1][rowIndex+1];
        for (int i = 1; i < rowIndex+1; i++) {
            ans[i][1] = 1;
            ans[i][i] = 1;
            for (int j = 2; j < i; j++) {
                ans[i][j] = ans[i-1][j-1] + ans[i-1][j];
            }
        }
        return ans[rowIndex][columnIndex];
    }
}
