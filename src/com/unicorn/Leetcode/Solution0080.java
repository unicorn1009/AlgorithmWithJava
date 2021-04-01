package com.unicorn.Leetcode;

import java.util.Arrays;

/**
 * <p>
 *     80. 删除有序数组中的重复项 II
 * </p>
 * Created on 2021/04/01 14:46
 *
 * @author Unicorn
 */
public class Solution0080 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,2,3};
        int duplicates = removeDuplicates(arr);
        System.out.println(duplicates);
        System.out.println(Arrays.toString(arr));

    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]){
                count++;
            }else {
                count = 1;
            }
            if (count <= 2){
                // 不同, 则nums[j] = nums[i] j++;
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
