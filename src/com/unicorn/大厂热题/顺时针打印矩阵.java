package com.unicorn.大厂热题;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021-7-30.
 *
 * @author Unicorn
 */
public class 顺时针打印矩阵 {
    public static void main(String[] args) {

    }

    public List<Integer> printMatrix(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int r1 = 0, c1 = 0;
        int r2 = matrix.length - 1, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            // 上
            for (int i = c1; i <= c2; i++)
                ans.add(matrix[r1][i]);
            // 右
            for (int i = r1 + 1; i <= r2; i++)
                ans.add(matrix[i][c2]);
            if (r1 != r2)
                // 下
                for (int i = c2 - 1; i >= c1; i--)
                    ans.add(matrix[r2][i]);
            if (c1 != c2)
                // 左
                for (int i = r2 - 1; i > r1; i--)
                    ans.add(matrix[i][c1]);
            r1++; r2--; c1++; c2--;
        }
        return ans;
    }
}
