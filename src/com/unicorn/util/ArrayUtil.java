package com.unicorn.util;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *     数组相关工具类
 * </p>
 * Created on 2021/3/16 0016
 *
 * @author Unicorn
 */
public class ArrayUtil {
    public static void main(String[] args) {

    }
    public static int[] ListToIntArray(List<Integer> list){
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    // 方括号转大括号
    public static String ArrayConvert(String str){
        return str.replace('[', '{').replace(']', '}');
    }

    /**
     * 打印二维数组
     */
    public static void printArray2D(Object[][] arrs){
        StringBuilder stringBuilder = new StringBuilder();
        for (Object[] arr : arrs) {
            stringBuilder.append(Arrays.toString(arr));
            stringBuilder.append(',');
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        System.out.println(stringBuilder.toString());
    }

    /**
     * 打印二维数组
     */
    public static void printArray2D(int[][] arrs){
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] arr : arrs) {
            stringBuilder.append(Arrays.toString(arr));
            stringBuilder.append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-2);
        System.out.println(stringBuilder.toString());
    }

    /**
     * 打印一维数组
     */
    public static void printArray1D(int[] arr){
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : arr) {
            stringBuilder.append(num);
            stringBuilder.append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-2);
        System.out.println(stringBuilder.toString());
    }

    /**
     * 打印一维数组
     */
    public static void printArray1D(Object[] arr){
        StringBuilder stringBuilder = new StringBuilder();
        for (Object obj : arr) {
            stringBuilder.append(obj);
            stringBuilder.append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-2);
        System.out.println(stringBuilder.toString());
    }

}
