package com.unicorn.Leetcode;

/**
 * <p>
 *     给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * </p>
 * Created on 2021/04/28 09:33
 *
 * @author Unicorn
 */
public class Solution0633 {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.out.println(i + " : " + new Solution0633().judgeSquareSum(i));
        }
    }

    static final double THRESHOLD = 0.000001;

    public boolean judgeSquareSum(int c) {
        int maxB = (int)Math.sqrt(c);
        for (int i = maxB; i >= 0; i--) {
             if (isExistA(c-i*i))
                 return true;
        }
        return false;
    }

    // 是否存在一个整数的平方=x
    private boolean isExistA(int x){
        double sqrt = Math.sqrt(x);
        int sqrt1 = (int) sqrt;
        return  (sqrt - sqrt1) < THRESHOLD;
    }
}
