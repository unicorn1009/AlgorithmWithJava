package com.unicorn;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * </p>
 * Created on 2021/5/31.
 *
 * @author Unicorn
 */
public class Solution0001 {
    public static void main(String[] args) {
        int n = fun2(fun1(101))%4;
        System.out.println(n);
    }

    public static int fun1(int i){
        return i <= 1 ? 1:fun1(i-1)+fun1(i-3);
    }

    public static int fun2(int i){
        return ((i>>4)|2021)|(((i<<4)|831)>>4);
    }
}
