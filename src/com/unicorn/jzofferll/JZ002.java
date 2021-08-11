package com.unicorn.jzofferll;

/**
 * <p>
 *     剑指 Offer II 002. 二进制加法
 *     给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * </p>
 * Created on 2021-8-9.
 *
 * @author Unicorn
 */
public class JZ002 {
    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
    public static String addBinary(String a, String b) {
        // 模拟
        int aLen = a.length(), bLen = b.length();
        int maxLen = Math.max(aLen, bLen);
        int flag = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            char aChar = '0';
            char bChar = '0';
            if (aLen-i-1 >= 0) aChar=a.charAt(aLen-i-1);
            if (bLen-i-1 >= 0) bChar=b.charAt(bLen-i-1);
            int cur = aChar - '0' + bChar - '0' + flag;
            if (cur > 1){   // 要进位了
                flag = 1;
                cur = cur % 2;
            }else {
                flag = 0;
            }
            ans.insert(0, cur);
        }
        if (flag==1) ans.insert(0, '1');
        return ans.toString();
    }
}
