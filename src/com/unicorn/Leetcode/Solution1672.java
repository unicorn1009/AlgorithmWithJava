package com.unicorn.Leetcode;

/**
 * <p>
 * </p>
 * Created on 2021/04/08 19:51
 *
 * @author Unicorn
 */
public class Solution1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int temp = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                temp += account[j];
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}
