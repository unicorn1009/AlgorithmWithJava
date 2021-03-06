package com.unicorn.Leetcode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <p>
 *     26. 删除排序数组中的重复项
 *          -- 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * </p>
 * Created on 2021-01-31.
 *
 * @author Unicorn
 */
public class Solution0026 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};
        int i = removeDuplicates(arr);
        System.out.println(i);
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length <=1) return nums.length;
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int i = 0;
        for (Integer integer : set) {
            nums[i++] = integer;
        }
        String a = "aaa";
        a.indexOf("ll");
        return set.size();
    }
}
