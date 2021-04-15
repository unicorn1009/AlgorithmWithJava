package com.unicorn.Leetcode;

/**
 * <p>
 *     154. 寻找旋转排序数组中的最小值 II
 * </p>
 * Created on 2021/04/09 09:40
 *
 * @author Unicorn
 */
public class Solution0154 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,0,1,2,3,5};
        int ans = new Solution0154().findMin(arr);
        System.out.println(ans);
    }
    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length-1]) return nums[0];

        // 找到数组中唯一一个左边比自己大的数
        return findMin(nums, 0, nums.length-1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (left > right) return Integer.MIN_VALUE;
        if (left == right) return nums[left];
        if (nums[left] < nums[right]) return nums[left];
        int mid = (left + right) /2;
        if (mid>0 && nums[mid-1] > nums[mid]){
            return nums[mid];
        }else if (mid < nums.length-1 && nums[mid] > nums[mid+1]){
            return nums[mid+1];
        }
        else{
            // 左右都有可能
            int leftAns = findMin(nums, left, mid);
            int rightAns = findMin(nums, mid+1, right);
            return Math.min(leftAns, rightAns);
        }
    }
}
