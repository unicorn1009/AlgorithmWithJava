package com.unicorn.笔试.yuanfudao;

import java.util.Scanner;

/**
 * <p>
 *     [][]3[[[]]2[]]4[] = 4+24+1=29
 * </p>
 * Created on 2021-7-31.
 *
 * @author Unicorn
 */
public class T03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String boxes = sc.nextLine();
            int n = boxes.length();
            int rs = 0;
            int avl = 0;
            int i = 0;
            int[] innerBoxNum = new int[11];
            while (i < n) {
                char ch = boxes.charAt(i);
                if (ch == '[') {
                    avl++;
                    //进入下一个层级 初始化为1 即[]的情况
                    innerBoxNum[avl] = 1;
                } else {
                    int times = 1;
                    // 对]后的数字做特殊处理，获得当前层级的倍率
                    if (i + 1 < n && Character.isDigit(boxes.charAt(i + 1))) {
                        times = boxes.charAt(i + 1) - '0';
                        i++;
                    }
                    innerBoxNum[avl] *= times;
                    // 退出层级avl 进入avl - 1
                    avl--;
                    innerBoxNum[avl] += innerBoxNum[avl + 1];
                }
                i++;
            }
            System.out.println(innerBoxNum[0]);
        }
    }

}
