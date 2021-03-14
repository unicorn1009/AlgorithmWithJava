package com.unicorn.jzoffer;

import java.util.Arrays;

/**
 * <p>
 *     剑指 Offer 14- I. 剪绳子
 * </p>
 *
 * @author unicorn
 * @create 2021-03-14 10:47 上午
 */
public class JZ014_1 {
    public static void main(String[] args) {
        cuttingRope(10);
    }

    public static int cuttingRope(int n) {
        if (n <= 3) return n-1;
        int[] maxProduct = new int[n+1];
        maxProduct[1] = 1;
        maxProduct[2] = 2;
        maxProduct[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                int curProduct = j * maxProduct[i - j];
                if (max < curProduct){
                    max = curProduct;
                }
            }
            maxProduct[i] = max;
        }
        System.out.println(Arrays.toString(maxProduct));
        return maxProduct[n];
    }
}
