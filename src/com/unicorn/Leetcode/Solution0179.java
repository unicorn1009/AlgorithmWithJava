package com.unicorn.Leetcode;

import java.util.Arrays;

/**
 * <p>
 *     179. 最大数
 * </p>
 *
 * @author unicorn
 * @create 2021-04-12 9:47 上午
 */
public class Solution0179 {
    public static void main(String[] args) {
        System.out.println(new Solution0179().largestNumber(new int[]{0, 0, 0}));
    }
    public String largestNumber(int[] nums) {
        // 思路, 先按最高位排序,最高位相同则按次高位排序(降序),注意长度不同时的特殊情况
        // 选择排序
//        int[] sortNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int maxIndex=i, maxValue = nums[i];
            for (int j = i; j < nums.length; j++) {
                // 找到最大的,与i位置交换
                if (compare(maxValue, nums[j])<0){
                    maxIndex = j;
                    maxValue = nums[j];
                }
            }
            swap(nums, i, maxIndex);
        }
        // 去除前导0
        int index = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == 0){
                index++;
            }else {
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = index; i < nums.length; i++) {
            stringBuilder.append(nums[i]);
        }
        return stringBuilder.toString();
    }

    private int compare(int num1, int num2){
        String s1 = String.valueOf(num1) + String.valueOf(num2);
        String s2 = String.valueOf(num2) + String.valueOf(num1);
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) > s2.charAt(i)){
                return 1;
            }else if (s1.charAt(i) < s2.charAt(i)) {
                return -1;
            }
        }
        return 0;

    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
