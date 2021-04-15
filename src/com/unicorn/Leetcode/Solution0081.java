package com.unicorn.Leetcode;

/**
 * <p>
 *     81. 搜索旋转排序数组 II
 * </p>
 * Created on 2021/04/09 10:24
 *
 * @author Unicorn
 */
public class Solution0081 {
    public boolean search(int[] nums, int target) {
        return false;
    }

//    private boolean bSearch(int[] nums, int target, int left, int right){
//        int mid = (left + right) /2;
//        if (nums[mid] == target) {
//            return true;
//        }else if (nums[mid] > target){
//            if (nums[mid] > nums[left] && nums[mid] > nums[right]){
//                // 旋转点在右侧,左边递增
//                boolean leftAns = bSearch(nums, target, left, mid - 1);
//            }else if ()
//        }
//    }
}
