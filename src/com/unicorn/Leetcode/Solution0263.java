package com.unicorn.Leetcode;

/**
 * <p>
 *     263. 丑数
 * </p>
 *
 * @author unicorn
 * @create 2021-04-10 10:08 下午
 */
public class Solution0263 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(i + " : "+isUgly(i));
        }
    }
    public static boolean isUgly(int n) {
        if (n <= 0) return false;
        boolean flag = true;
        while (flag){
            flag = false;
            if (n % 2 == 0){
                n /= 2;
                flag = true;
            }
            if (n % 3 == 0){
                n /= 3;
                flag = true;
            }
            if (n % 5 == 0){
                n /= 5;
                flag = true;
            }
        }
        return n == 1;
    }
}
