package mianshi.tx0811;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-08-11 3:18 下午
 */
public class Main4 {
    public static void main(String[] args) {
    }

    public static int sumMatrix(int[][] matrix) {
        int ret = 0;
        int r1 = 0, c1 = 0;
        int r2 = matrix.length - 1, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            // 上
            for (int i = c1; i <= c2; i++) {
                ret += matrix[r1][i];
            }
            // 右
            for (int i = r1 + 1; i <= r2; i++) {
                ret += matrix[i][c2];
            }
            if (r1 != r2)
                // 下
                for (int i = c2 - 1; i >= c1; i--) {
                    ret += matrix[r2][i];
                }
            if (c1 != c2)
                // 左
                for (int i = r2 - 1; i > r1; i--) {
                    ret += matrix[i][c1];
                }
            r1++; r2--; c1++; c2--;
        }
        System.out.println(ret);
        return ret;
    }
}
