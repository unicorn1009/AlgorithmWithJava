package com.unicorn.jzoffer;

/**
 * <p>
 * 剑指 Offer 66. 构建乘积数组
 * </p>
 *
 * @author unicorn
 * @create 2021-03-29 11:51 下午
 */
public class JZ066 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        dp1[0] = 1;
        for (int i = 1; i < len; i++) {
            dp1[i] = dp1[i - 1] * a[i - 1];
        }
        dp2[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            dp2[i] = dp2[i + 1] * a[i + 1];
        }
        for (int i = 0; i < len; i++) {
            a[i] = dp1[i] * dp2[i];
        }
        return a;
    }
}
