package com.unicorn.Leetcode;

/**
 * <p>
 *     74. 搜索二维矩阵
 *     编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 *      每行中的整数从左到右按升序排列。
 *      每行的第一个整数大于前一行的最后一个整数。
 *
 * </p>
 * Created on 2021/03/30 09:15
 *
 * @author Unicorn
 */
public class Solution0074 {
    public static void main(String[] args) {

    }
    // 二分
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        if (col == 0) return false;
        if (row == 1){
            for (int i = 0; i < col; i++){
                if (target == matrix[0][i]){
                    return true;
                }
            }
            return false;
        }

//        每次找中间行的最中间一个数, 直到行数相差1
        int[] left = new int[]{0,0};
        int[] right = new int[]{row-1,col-1};
        while (left[0]+1 != right[0] ){
            int midRow = (left[0] + right[0]) /2;
            int midCol = (col-1)/2;
            if (target == matrix[midRow][midCol]){
                return true;
            }else if (target > matrix[midRow][midCol]){
                // 找右下
                left[0] = midRow;
                left[1] = midCol;
            }else {
                // 找左上
                right[0] = midRow;
                right[1] = midCol;
            }
        }
        // 此时行列相差1
        for (int i = left[1]; i< col; i++){
            if (target == matrix[left[0]][i]){
                return true;
            }
        }
        for (int i = 0; i <= right[1]; i++){
            if (target == matrix[right[0]][i]){
                return true;
            }
        }
        return false;
    }
}
