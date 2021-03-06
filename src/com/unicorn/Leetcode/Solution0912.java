package com.unicorn.Leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * <p>
 *     912. 排序数组
 *     手撕快排
 * </p>
 * Created on 2021/04/03 16:46
 *
 * @author Unicorn
 */
public class Solution0912 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,1,0,6,11,44,45,12,4,7,8,2,22,41};
        int[] ans = new Solution0912().sortArray(arr);
        System.out.println(Arrays.toString(ans));
    }

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length-1);
        return nums;
    }

    // 快排3.0
    private void sort(int[] arr, int left, int right){
        if (left >= right) return;
        swap(arr, left + (int) (Math.random()*(right-left+1)), right);
        int[] partition = partition(arr, left, right);
        sort(arr, left, partition[0]-1);
        sort(arr, partition[1]+1, right);
    }

    private int[] partition(int[] arr, int left, int right){
        int pivot = arr[right];
        int i = left-1, j = right;
        int k = left;
        while (k < j){
            if (arr[k] < pivot){
                i++;
                swap(arr, i, k);
                k++;
            }else if (arr[k] > pivot){
                j--;
                swap(arr, k, j);
            }else {
                k++;
            }
        }
        swap(arr, j, right);
        return new int[]{i+1, j};
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
