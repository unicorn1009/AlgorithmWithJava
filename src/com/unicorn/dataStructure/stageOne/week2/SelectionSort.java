package com.unicorn.dataStructure.stageOne.week2;

import com.unicorn.common.ArrayGenerate;
import com.unicorn.common.SortingHelper;

public class SelectionSort {
    private SelectionSort(){}

    public static void main(String[] args) {
        Integer[] array = ArrayGenerate.generateArrayRandom(10000, 1000);
        SortingHelper.sortTest("SelectionSort", array);
//        String[] arr = {"ahs", "djnm", "sadhj", "asbdj", "12s", "11s"};
//        long startTime = System.nanoTime();
//        SelectionSort.sort(array);
//        long endTime = System.nanoTime();
//
//        if (!SortingHelper.isSorted(array)){
//            System.out.println("错误");
//            return;
//        }
//
//        double time = (endTime - startTime) / 1000000000.0;
//
//        System.out.println("time: " + time);

//        for (Integer i : array)
//            System.out.print(i + " ");

    }

    public static <E extends Comparable<E>> void sort(E[] arr){
        for (int i = 0; i < arr.length; i++) {
            // 选出[i, end]中最小的值
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            // 交换位置
            E temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
