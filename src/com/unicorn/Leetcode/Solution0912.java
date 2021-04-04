package com.unicorn.Leetcode;

import java.util.Arrays;

/**
 * <p>
 * </p>
 * Created on 2021/04/03 16:46
 *
 * @author Unicorn
 */
public class Solution0912 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,1,1,2,0,0,4,6,11,44,2,45,12,45,11,4,5,7,8,2,22,41,44};
        int[] ans = new Solution0912().sortArray(arr);
        System.out.println(Arrays.toString(ans));
    }

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length-1);
        return nums;
    }

    private void sort(int[] arr, int left, int right){
        if (left >= right) return;
        int partition = partition(arr, left, right);
        sort(arr, left, partition-1);
        sort(arr, partition+1, right);
    }

    private int partition(int[] arr, int left, int right){
        int pivot = arr[left];
        int i = left+1, j = right;
        while (i < j){
            while (i < j && arr[i] < pivot)
                i++;
            while (i < j && arr[j] > pivot)
                j--;

            swap(arr, i, j);
            i++;j--;
        }
        swap(arr, left, j);
        return j;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
