package com.unicorn.common;

import com.unicorn.dataStructure.stageOne.week2.InsertionSort;
import com.unicorn.dataStructure.stageOne.week2.SelectionSort;

public class SortingHelper {
    private SortingHelper(){}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1].compareTo(arr[i]) > 0)
                return false;
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr){
        long startTime = System.nanoTime();
        if (sortName.equals("SelectionSort"))
            SelectionSort.sort(arr);
        else if (sortName.equals("InsertionSort"))
            InsertionSort.sort(arr);
        long endTime = System.nanoTime();

        if (!SortingHelper.isSorted(arr)){
            System.out.println("排序错误");
            return;
        }
        double time = (endTime - startTime) / 1000000000.0;

        System.out.printf("%s , n = %d, time = %f s%n", sortName, arr.length, time);
    }

    public static <E extends Comparable<E>> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

