package com.unicorn.Leetcode;

/**
 * <p>
 * </p>
 * Created on 2021/6/15.
 *
 * @author Unicorn
 */
public class Solution0852 {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1};
        int i = peakIndexInMountainArray(arr);
        System.out.println(i);
    }

    public int peakIndexInMountainArray1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i>0 && arr[i] < arr[i-1]){
                return i-1;
            }
        }
        return -1;
    }

    public static int peakIndexInMountainArray(int[] arr) {
        // 二分法
        int left = 0, right = arr.length-1;
        int mid = 0;
        while (left < right){
            mid = left + (right-left)/2;
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }
            if (arr[mid] > arr[mid-1]){
                // 当前mid大于前一个, 答案在右边, 当前mid是一个可能答案
                left = mid;
            }else {
                // arr[mid] < arr[mid-1]
                // 当前mid小于前一个, 答案在左边, 当前mid是一个可能答案
                right = mid;
            }
        }
        return mid;
    }
}
