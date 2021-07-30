package com.unicorn.笔试.牛客0729;

import java.util.HashSet;
import java.util.Scanner;

/**
 * <p>
 *     字母矩阵
 * </p>
 * Created on 2021-7-29.
 *
 * @author Unicorn
 */
public class T03 {

    public static void main(String[] args) {
        // 5 5 3
        //
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            char[][] matrix = new char[n][m];
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                String str = sc.nextLine();
                matrix[i] = str.toCharArray();
            }
            solution(matrix, k);

        }
    }

    public static void solution(char[][] matrix, int k){
        int row = matrix.length;
        int col = matrix[0].length;
        // 最小窗口边长为根号k向上取整
        int minWindow = (int)Math.ceil(Math.sqrt(k));
        for (int i = minWindow; i < Math.min(row, col); i++) {
            for (int j = 0; j < row; j++) {
                for (int l = 0; l < col; l++) {
                    // 左上角坐标(j, l), 右下角坐标(j+i-1, l+i-1)
                    if (j+i-1 < row && l+i-1 < col){
                        HashSet<Character> charNum = new HashSet<>();
                        for (int m = j; m <= j + i - 1; m++) {
                            for (int n = l; n <= l+i-1; n++) {
                                charNum.add(matrix[m][n]);
                                if (charNum.size() >= k){
                                    System.out.println(i);
                                    return;
                                }
                            }
                        }
                    }else {
                        break;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
