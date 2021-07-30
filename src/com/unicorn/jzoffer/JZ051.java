package com.unicorn.jzoffer;

import java.util.Arrays;

/**
 * <p>
 *     数组中的逆序对 : 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *     暴力解时间复杂度O(n^2)
 *     思路 : 利用归并排序的思想
 * </p>
 * Created on 2021/2/23.
 *
 * @author Unicorn
 */
public class JZ051 {
    public static void main(String[] args) {
        int[] data = new int[]{3,55, 23, 21};
        System.out.println(Arrays.toString(data));
        System.out.println(new JZ051().reversePairs(data));
        System.out.println(Arrays.toString(data));
    }

    private int res;

    public int reversePairs(int[] nums){
        res = 0;
        mergeSort(nums);
        return res;
    }

    public void mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length-1, temp);
    }

    public void sort(int[] arr, int left, int right, int[] temp){
        if (left>=right){
            return;
        }
        int mid = (left+right)/2;
        sort(arr, left, mid, temp);
        sort(arr, mid+1, right, temp);
        if (arr[mid] > arr[mid+1])
            merge(arr, left, mid, right, temp);
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        System.arraycopy(arr, left, temp, left, right-left+1);
        int i = left, j = mid+1;
        for (int k = left; k <= right; k++) {
            if (i > mid){
                arr[k] = temp[j];
                j++;
            }else if (j > right){
                arr[k] = temp[i];
                i++;
            }else if (temp[i] <= temp[j]){
                arr[k] = temp[i];
                i++;
            }else {
                arr[k] = temp[j];
                res += (mid-i+1);
                j++;
            }
        }
    }
}
