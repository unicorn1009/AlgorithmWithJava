package com.unicorn.jzoffer;

/**
 * <p>
 *     剑指 Offer 67. 把字符串转换成整数
 * </p>
 * Created on 2021/3/14.
 *
 * @author Unicorn
 */
public class JZ067 {
    public static void main(String[] args) {
        String s = "  0000000000012345678";
        System.out.println("结果: " +strToInt(s));
    }
    public static int strToInt(String str) {
        String str1 = str.trim();
        if (str1.length() == 0) return 0;
        boolean flag = false;
        if (str1.charAt(0) == '+' || str1.charAt(0) == '-'){
            if (str1.charAt(0) == '-') flag = true;
            str1 = str1.substring(1);
        }
        if (str1.length() == 0) return 0;
        String numStr = getNumStr(str1);
        int n = numStr.length();
        if (n == 0) return 0;
        long ret = 0;
        for (int i = 0; i < n; i++) {
            int anInt = Integer.parseInt(String.valueOf(numStr.charAt(i)));
            ret += anInt * Math.pow(10, n-i-1);
        }
        if (flag){
            ret = -ret;
        }
        if (ret > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (ret < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) ret;
    }

    // 传入一个不带符号的字符串, 返回一个只包含数字的字符串
    private static String getNumStr(String str){
        int i = 0;
        while (i < str.length()){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                i++;
            }else {
                break;
            }
        }
        return str.substring(0,i);
    }
}
