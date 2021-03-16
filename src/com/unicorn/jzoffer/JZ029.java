package com.unicorn.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 输入：matrix = [ [1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 提示：
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * </p>
 * Created on 2021/2/25.
 *
 * @author Unicorn
 */
public class JZ029 {
    public static void main(String[] args) {
        int[][] arr = new int[3][4];
        arr[0] = new int[]{1, 2, 3, 4};
        arr[1] = new int[]{5, 6, 7, 8};
        arr[2] = new int[]{9, 10, 11, 12};
        new JZ029().spiralOrder(arr);
        // 1,2,3,4,8,12,11,10,9,5,6,7

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>(0);
        if (matrix.length == 1){
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < matrix[0].length; i++) {
                list.add(matrix[0][i]);
            }
            return list;
        }
        int length = matrix[0].length;
        int width = matrix.length;
        int amount = length * width;

        ArrayList<Integer> arrayList = new ArrayList<>();

        int[] zuobiao = new int[]{0, -1};
        int loop = 0;

        while (amount > 0) {
            // 转一圈, 长度-2, 宽度-2
            // 从左到右, 列++
            for (int i = zuobiao[1]+1; i < length; i++) {
                zuobiao[1] = i;
                arrayList.add(matrix[zuobiao[0]][zuobiao[1]]);
                amount--;
            }
            if (amount == 0) break;
            // 从上到下, 行++
            for (int i = zuobiao[0] + 1; i < width; i++) {
                zuobiao[0] = i;
                arrayList.add(matrix[zuobiao[0]][zuobiao[1]]);
                amount--;
            }
            if (amount == 0) break;

            // 从右到左, 列--
            for (int i = zuobiao[1] - 1; i >= loop; i--) {
                zuobiao[1] = i;
                arrayList.add(matrix[zuobiao[0]][zuobiao[1]]);
                amount--;
            }
            if (amount == 0) break;

            // 从下到上, 行--
            for (int i = zuobiao[0] - 1; i > loop; i--) {
                zuobiao[0] = i;
                arrayList.add(matrix[zuobiao[0]][zuobiao[1]]);
                amount--;
            }
            if (amount == 0) break;
            length -= 1;
            width -= 1;
            loop++;
        }

        System.out.println(arrayList);

        return arrayList;
    }
}
