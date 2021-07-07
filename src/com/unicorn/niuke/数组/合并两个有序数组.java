package com.unicorn.niuke.数组;

import java.util.Arrays;

/**
 * <p>
 *     将B中所有数字合并到A中, A中有足够空间容纳B数组
 * </p>
 * Created on 2021/04/27 10:32
 *
 * @author Unicorn
 */
public class 合并两个有序数组 {
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        for (int i = 0; i < 6; i++) {
            arr1[i] = i-2;
        }
        int[] arr2 = new int[]{1,2,3};
        merge(arr1, 6, arr2, 3);
        System.out.println(Arrays.toString(arr1));
    }

    public static void merge(int[] A, int m, int[] B, int n) {
        if (n == 0) return;
        int index = m+n-1;
        n--;
        m--;
        while (n >= 0){
            if (m>=0 && A[m] >= B[n]){
                A[index--] = A[m--];
            }else {
                A[index--] = B[n--];
            }
        }
    }
}
