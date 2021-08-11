package com.unicorn.Leetcode;

/**
 * <p>
 * </p>
 * Created on 2021-8-10.
 *
 * @author Unicorn
 */
public class Solution0008 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println("=================");
        System.out.println(myAtoi("2147483647"));
        System.out.println(myAtoi("-2147483648"));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("+1"));
    }
    public static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        boolean isNegative = false; // 负数标记
        if (s.charAt(0) == '-'){
            isNegative = true;
        }
        long ans = 0;
        for (int i = 0 ; i < s.length(); i++) {
            // 如果第一个字符是正负号,则跳过
            if (i == 0 && (s.charAt(0) == '-' || s.charAt(0) == '+')){
                continue;
            }
            // 判断当前字符是否是数字, 如果是, 则累加, 如果不是, 则结束遍历
            int cur = s.charAt(i) - '0';
            if (cur >= 0 && cur <= 9){
                ans = ans * 10 + cur;
            }else {
                break;
            }
            // 判断是否越界
            if (isNegative &&  ans > Integer.MAX_VALUE){
                return Integer.MIN_VALUE;
            }else if (ans > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }
        return isNegative ? -(int) ans : (int) ans;
    }
}
