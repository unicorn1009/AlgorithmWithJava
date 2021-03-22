package com.unicorn.Leetcode;

/**
 * <p>
 *     1128. 等价多米诺骨牌对的数量
 * </p>
 * Created on 2021-01-26.
 *
 * @author Unicorn
 */
public class Solution1128 {
    public static void main(String[] args) {

    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        int[] arr = new int[100];
        for (int i = 0; i < dominoes.length; i++) {
            int temp;
            if (dominoes[i][0] <= dominoes[i][1]){
                temp = dominoes[i][0] * 10 + dominoes[i][1];
            }else {
                temp = dominoes[i][1] * 10 + dominoes[i][0];
            }
            arr[temp] += 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1){
                count += arr[i]*(arr[i]-1)/2;
            }
        }
        return count;
    }
}
