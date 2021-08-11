package com.unicorn.Leetcode;

import java.util.Arrays;

/**
 * <p>
 *     31. 下一个排列
 *     实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 *      如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 *      必须 原地 修改，只允许使用额外常数空间。
 * </p>
 * Created on 2021-02-02.
 *
 * @author Unicorn
 */
public class Solution0031 {
    public static void main(String[] args) {
        int[] n = new int[]{1,2,3};
        nextPermutation(n);
        System.out.println(Arrays.toString(n));
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        // 从后往前找第一个变小的数字
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        // 除了while循环，有两种情况，一是i==-1了， 二是找到了num[i] < num[i+1]
        if (i >= 0){
            // 从后往前找第一个比num[i]大的数，与num[i]交换
            for (int j = n-1; j > i; j--){
                if (nums[j] > nums[i]){
                    // 找到了
                    swap(nums, i, j);
                    break;
                }
            }
        }
        // 交换完后，需要把后面一部分整体反转，使后面一部分是最小的
        reverse(nums, i+1, n-1);
    }

    private static void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // 反转数组区间[lo, hi]
    private static void reverse(int[] nums, int lo, int hi){
        while (lo < hi){
            swap(nums, lo++, hi--);
        }
    }
}
