package com.unicorn.util;

import java.util.List;

/**
 * <p>
 *     数组相关工具类
 * </p>
 * Created on 2021/3/16 0016
 *
 * @author Unicorn
 */
public class ArrayHelper {
    public static void main(String[] args) {

    }
    public static int[] ListToIntArray(List<Integer> list){
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
