package com.unicorn.大厂热题;

/**
 * <p>
 * </p>
 * Created on 2021-7-23.
 *
 * @author Unicorn
 */
public class 二分查找 {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        // 递归版本
        return search(nums, 0, nums.length-1, target);
    }

    // 在[left, right]内查找
    public int search(int[] nums, int left, int right, int target){
        if (left > right)
            return -1;
        int mid = left + (right-left)/2;
        if (target == nums[mid]){
            return mid;
        }else if (target < nums[mid]){
            return search(nums, left, mid-1, target);
        }else {
            return search(nums, mid+1, right, target);
        }
    }
}
