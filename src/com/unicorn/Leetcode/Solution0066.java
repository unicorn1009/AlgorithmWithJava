package com.unicorn.Leetcode;

import com.unicorn.util.ArrayUtil;

import java.util.Arrays;

/**
 * <p>
 *     66. 加一
 * </p>
 *
 * @author unicorn
 * @create 2021-03-22 11:00 下午
 */
public class Solution0066 {
    public static void main(String[] args) {
        int[] arr = {9};
        int[] ans = new Solution0066().plusOne(arr);
        ArrayUtil.printArray1D(ans);
    }
    public int[] plusOne(int[] digits) {
        boolean flag = true;
        for (int i = digits.length-1; i >= 0; i--) {
            if (flag){
                // 当前位需加1;
                if (digits[i] == 9){
                    digits[i] = 0;
                }else {
                    digits[i] += 1;
                    flag = false;
                    break;
                }
            }
        }
        if (flag){
            int[] ans = new int[digits.length+1];
            ans[0] = 1;
            return ans;
        }else {
            return digits;
        }
    }
}
