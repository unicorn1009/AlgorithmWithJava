package com.unicorn.jzoffer;

/**
 * <p>
 *     剑指 Offer 53 - II. 0～n-1 中缺失的数字
 *     一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * </p>
 * Created on 2021/3/3.
 *
 * @author Unicorn
 */
public class JZ053_2 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3};
        System.out.println(new JZ053_2().missingNumber(arr));
    }
    // 二分查找
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length-1;
        while (i <= j){
            if (i == j) break;
            int mid = (i+j)/2;
            if (nums[mid] == mid){
                // 缺失值在右边
                i = mid+1;
            }else if (nums[mid] > mid){
                // 缺失值在左边
                j = mid;
            }
        }
        if (i == nums.length-1 && nums[i] == i)
            return i+1;
        else return i;
    }
}
