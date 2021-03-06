package com.unicorn.Leetcode;

import java.util.Arrays;

/**
 * <p>
 *     31. 下一个排列
 * </p>
 * Created on 2021-02-02.
 *
 * @author Unicorn
 */
public class Solution0031 {
    public static void main(String[] args) {
        int[] n = new int[]{1,3,2};
        nextPermutation(n);
        System.out.println(Arrays.toString(n));
    }
    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) return ;
        // 从尾部向头遍历, 直到遇见的数字减小了
        int last = -1;
        int cur = -1;
        int index1 = -1;
        int index2 = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            cur = nums[i];
            if (last <= cur){   // 前大后小, 不用换位置
                last = cur;
                continue;
            }else {             // 遇到第一个变小的, 与后面不比它小的第一个数字换位置
                index1 = i;
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > cur){
                        index2 = j;
                        break;
                    }
                }
                break;
            }
        }

        if (index1 != -1){  // 需要换位置
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
            // 还需要对前面位置后面部分数组进行排序, 其实相当于将后面一部分反转一下
            Arrays.sort(nums, index1+1,nums.length);
        }else {
            Arrays.sort(nums);
        }
    }
}
