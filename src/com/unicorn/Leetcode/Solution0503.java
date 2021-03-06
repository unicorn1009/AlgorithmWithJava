package com.unicorn.Leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>
 * </p>
 * Created on 2021/3/6.
 *
 * @author Unicorn
 */
public class Solution0503 {
    public static void main(String[] args) {
        int[] ans = nextGreaterElements2(new int[]{1, 2, 1});
        System.out.println(Arrays.toString(ans));
    }

    // 法二 : 单调栈
    public static int[] nextGreaterElements2(int[] nums) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < nums.length * 2){
            i = i % nums.length;

        }
        return null;
    }


    // 暴力解法1
    public static int[] nextGreaterElements1(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] > nums[i]){
                    ans[i] = nums[j];
                    flag = true;
                    break;
                }
            }
            if (!flag){
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]){
                        ans[i] = nums[j];
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag)
                ans[i] = -1;
        }
        return ans;
    }
}
