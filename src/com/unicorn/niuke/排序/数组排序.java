package com.unicorn.niuke.排序;

import com.unicorn.util.ArrayUtil;

/**
 * <p>
 * </p>
 * Created on 2021/04/19 09:48
 *
 * @author Unicorn
 */
public class 数组排序 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 2, 8, 5, 6, 2, 3, 1, 7, 5, 2, 3, 1, 8, 9};
        new 数组排序().MySort(arr);
        ArrayUtil.printArray1D(arr);
    }

    public int[] MySort (int[] arr) {
        // 快排
        quickSort(arr, 0, arr.length-1);
        return arr;
    }

    private void quickSort(int[] arr, int left, int right){
        if (left >= right) return;
        swap(arr,left + (int) (Math.random()*(right-left+1)), right);
        int[] index = partition(arr, left, right);
        quickSort(arr,left, index[0]-1);
        quickSort(arr, index[1]+1, right);
    }

    // 传入一个数组和左右下标, 返回该范围数组划分后的中枢元素的左右下标
    private int[] partition(int[] arr, int left, int right){
        int i = left-1, j = right;
        int k = left; // 遍历指针
        int pivot = arr[right];
        while (k < j){
            if (arr[k] < pivot){
                i++;
                swap(arr, k, i);
                k++;
            }else if (arr[k] > pivot){
                j--;
                swap(arr, k, j);
                // 此时k不需要++, 需要继续判断交换到k位置的数字与pivot的大小关系
            }else {
                // arr[k] = pivot
                k++;
            }
        }
        swap(arr, right, j);
        return new int[]{i+1, j};
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
