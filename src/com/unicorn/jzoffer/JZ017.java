package com.unicorn.jzoffer;

/**
 * <p>
 *     打印从 1 到最大的 n 位数
 *     输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *     示例:
 *      输入: n = 1
 *      输出: [1,2,3,4,5,6,7,8,9]
 * </p>
 * Created on 2021/2/24.
 *
 * @author Unicorn
 */
public class JZ017 {
    public int[] printNumbers(int n) {
        int v = (int)Math.pow(10, n);
        int[] arr = new int[v-1];
        for (int i = 1; i < v; i++) {
            arr[i-1] = i;
        }
        return arr;
    }
}
