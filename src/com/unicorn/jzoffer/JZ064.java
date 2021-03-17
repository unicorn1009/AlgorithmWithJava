package com.unicorn.jzoffer;

/**
 * <p>
 *     剑指 Offer 64. 求1+2+…+n
 *     求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * </p>
 * Created on 2021/3/16 0016
 *
 * @author Unicorn
 */
public class JZ064 {
    public static void main(String[] args) {
        System.out.println(sumNums(100));
    }
    public static int sumNums(int n) {
        if (n == 1)
            return 1;
        return n + sumNums(n-1);
    }
}
