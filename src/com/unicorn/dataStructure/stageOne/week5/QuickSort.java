package com.unicorn.dataStructure.stageOne.week5;

import com.unicorn.common.ArrayGenerate;
import com.unicorn.common.SortingHelper;
import com.unicorn.jzoffer.JZ051;

import java.util.Arrays;
import java.util.Random;

/**
 * <p>
 *     快速排序
 *     时间复杂度 : 最坏会退化到O(n^2) 但几乎不可能, 期望复杂度O(nlogn)
 *     空间复杂度 : O(1)
 * </p>
 * Created on 2021/2/24.
 *
 * @author Unicorn
 */
public class QuickSort {
    public static void main(String[] args) {
        Integer[] arrayRandom = ArrayGenerate.generateArrayRandom(20);
        System.out.println(Arrays.toString(arrayRandom));
        int[] arr = new int[]{12, 0, 13, 11, 3, 15, 17, 9, 8, 10, 16, 5, 5, 16, 17, 8, 10, 2, 10, 19};
        new QuickSort().sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr, int left, int right){
        if (left >= right) return;
        int p = partition(arr, left, right);
            // 左边排序
        sort(arr, left, p-1);
            // 右边排序
        sort(arr, p+1, right);
    }

    private int partition(int[] arr, int left, int right) {
        // 优化点 : 随机选取枢轴元素. 将选中的枢轴元素交换到最左边
        int p = left + (new Random()).nextInt(right-left+1);
        swap(arr, left, p);

        int i = left+1, j = right;
        while (true){
            // 注意循环条件
            while (i <= j && arr[i] < arr[left])
                i++;
            // 注意循环条件
            while (i <= j && arr[j] > arr[left])
                j--;
            // 注意循环终止条件
            if (i >= j) break;
            swap(arr, i, j);
            i++;
            j--;
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
