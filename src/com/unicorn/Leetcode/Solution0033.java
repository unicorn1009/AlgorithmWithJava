package com.unicorn.Leetcode;

/**
 * <p>
 *     33. 搜索旋转排序数组
 * </p>
 * Created on 2021/04/08 09:46
 *
 * @author Unicorn
 */
public class Solution0033 {
    public static void main(String[] args) {
        int[] arr = new int[]{6};
        int ans = new Solution0033().search(arr, 6, 0, arr.length - 1);
        System.out.println(ans);
    }
    public int search(int[] nums, int target){
        return search(nums, target, 0, nums.length - 1);
    }
    public int search(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) /2;
        if (target == nums[mid]) return mid;
        if (target > nums[mid]){
            // 两种情况
            if (nums[mid] < nums[right]){
                // 如果分割点在左侧，
                // 中点右边单调递增
                int ret = binarySearch(nums, target, mid + 1, right);
                if (ret >= 0)
                    return ret;
                // 右边没有， 去左边找
                return search(nums, target, left, mid-1);
            }else {
                // 如果分割点在右侧
                // 只能去右边找
                return search(nums, target, mid+1, right);
            }
        }else {
            // target < nums[mid]
            // 两种情况
            if (nums[mid] < nums[right]){
                // 如果分割点在左侧，
                // 只能去左边找
                return search(nums, target, left, mid-1);
            }else {
                // 如果分割点在右侧
                // 左右都可能，左侧单调递增
                int ret = binarySearch(nums, target, left, mid - 1);
                if (ret >= 0)
                    return ret;
                // 左边没有，找右边
                return search(nums, target, mid+1, right);
            }
        }
    }

    // left-right内元素为单调递增
    private int binarySearch(int[] nums, int target, int left, int right){
        if (left > right) return -1;
        int mid = (left + right) /2;
        if (nums[mid] == target){
            return mid;
        }else if (nums[mid] < target){
            // 去右边找
            int ret = binarySearch(nums, target, mid + 1, right);
            if (ret >= 0){
                return ret;
            }else
                return -1;
        }else {
            // 去左边找
            int ret = binarySearch(nums, target, left, mid - 1);
            if (ret >= 0)
                return ret;
            else
                return -1;
        }
    }
}
