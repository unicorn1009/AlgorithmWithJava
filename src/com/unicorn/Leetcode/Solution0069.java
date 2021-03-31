package com.unicorn.Leetcode;

/**
 * <p>
 *     69. x 的平方根
 *     实现int sqrt(int x)函数。计算并返回x的平方根，其中x 是非负整数。由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * </p>
 * Created on 2021/03/30 09:37
 *
 * @author Unicorn
 */
public class Solution0069 {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(2147395600));
        System.out.println(Math.sqrt(Integer.MAX_VALUE));

        System.out.println(mySqrt(2147395600));
    }
    // 二分, 初始区间从0 到 x/2
    public static int mySqrt(int x) {
        if (x == 0 ) return 0;
        if (x < 4){
            return 1;
        }else if (x < 9){
            return 2;
        }
        long l = 0;
        long r = x/2;
        while (l < r){
            long mid = (l+r)/2;
            while (mid > 46341){
                mid = 46341;
            }
            long product = mid * mid;
            if (product <= x && (mid+1)*(mid+1) > x){
                return (int)mid;
            }else if (product < x){
                l = mid;
            }else {
                r = mid;
            }
        }
        return (int)l;
    }
}
