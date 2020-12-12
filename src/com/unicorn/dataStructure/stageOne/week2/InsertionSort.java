package com.unicorn.dataStructure.stageOne.week2;

import com.unicorn.common.Array;
import com.unicorn.common.ArrayGenerate;
import com.unicorn.common.SortingHelper;

public class InsertionSort {
    private InsertionSort(){}

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arrayRandom = ArrayGenerate.generateArrayRandom(n);
        Integer[] arrayOrdered = ArrayGenerate.generateArrayOrdered(n);

        // 数组有序时，插入排序复杂度为O(n), 无序时为O(n^2)
        SortingHelper.sortTest("InsertionSort",arrayRandom);
        SortingHelper.sortTest("InsertionSort",arrayOrdered);


    }

    // 性能更好
    public static <E extends Comparable<E>> void sort(E[] arr){
        for (int i = 1; i < arr.length; i++) {
            E temp = arr[i];
            int j;  // j为arr[i]要插入的位置
            for (j = i; j-1 >= 0 && temp.compareTo(arr[j-1]) < 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j].compareTo(arr[j-1]) < 0){
                    SortingHelper.swap(arr, j, j-1);
                }else break;
            }
        }
    }


}
