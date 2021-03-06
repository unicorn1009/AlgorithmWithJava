package com.unicorn.Leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * <p>
 *     888. 公平的糖果棒交换
 * </p>
 * Created on 2021-02-01.
 *
 * @author Unicorn
 */
public class Solution0888 {
    public static void main(String[] args) {
        int[] testa = new int[]{2};
        int[] testb = new int[]{1,3};
        int[] ints = fairCandySwap1(testa, testb);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] fairCandySwap(int[] A, int[] B) {
        int ASum = 0;
        int BSum = 0;
        int gap = 0;
        int[] result = new int[2];
        for (int i = 0; i < A.length; i++) {
            ASum += A[i];
        }
        HashSet<Integer> BSet = new HashSet<>();
        for (int i = 0; i < B.length; i++) {
            BSum += B[i];
            BSet.add(B[i]);
        }
        gap = ASum - BSum;  // 因为保证有答案, 所以一定是偶数
        for (int i = 0; i < A.length; i++) {
            int temp = A[i] - gap/2;
            if (BSet.contains(temp)){
                result[0] = A[i];
                result[1] = temp;
            }
        }
        return result;
    }

    public static int[] fairCandySwap1(int[] A, int[] B) {
        /*
            将HashSet换成数组
         */
        int ASum = 0;
        int BSum = 0;
        int gap = 0;
        int[] result = new int[2];
        for (int i = 0; i < A.length; i++) {
            ASum += A[i];
        }
        int[] BSet = new int[100001];
        for (int i = 0; i < B.length; i++) {
            BSum += B[i];
            BSet[B[i]] = 1;
        }
        gap = ASum - BSum;  // 因为保证有答案, 所以一定是偶数
        for (int i = 0; i < A.length; i++) {
            if (A[i] > gap/2){
                int temp = A[i] - gap/2;
                if (temp <=100000 && BSet[temp] == 1){
                    result[0] = A[i];
                    result[1] = temp;
                }
            }

        }
        return result;
    }
}
