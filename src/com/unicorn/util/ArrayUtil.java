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
     * 二维数组转字符串
     */
    public static String twoDiemArrayToString(int[][] arrs){
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] arr : arrs) {
            stringBuilder.append(Arrays.toString(arr));
            stringBuilder.append(',');
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

}
