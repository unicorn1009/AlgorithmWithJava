package com.unicorn.dataStructure.stageOne.week5;

import com.unicorn.jzoffer.JZ051;

import java.util.Arrays;

/**
 * <p>
 *     归并排序
 *     时间复杂度 : O(nlogn)
 *     空间复杂度 : O(n)
 * </p>
 * Created on 2021/2/22.
 *
 * @author Unicorn
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] data = new int[]{3,55, 23, 234, 1, 1, 13, 123, 42};
        new MergeSort().mergeSort(data);
        System.out.println(Arrays.toString(data));
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
        if (arr[mid] > arr[mid+1])      // 优化点
            merge(arr, left, mid, right, temp);
    }

    // 归并过程
    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 归并时, 将原数组中需要归并的部分复制到辅助数组中
        System.arraycopy(arr, left, temp, left, right-left+1);  // 优化点
        int i = left, j = mid+1;
        for (int k = left; k <= right; k++) {
            // 如果左边归并完了, 直接放入右边的元素即可
            if (i > mid){
                arr[k] = temp[j];
                j++;
            }else if (j > right){ // 如果右边归并完了, 直接放入左边的元素即可
                arr[k] = temp[i];
                i++;
            }else if (temp[i] <= temp[j]){	// 取二者之中较小
                arr[k] = temp[i];
                i++;
            }else {
                arr[k] = temp[j];
                j++;
            }
        }
    }
}
