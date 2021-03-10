package com.unicorn.jzoffer;

/**
 * <p>
 *     剑指 Offer 58 - II. 旋转字符串
 * </p>
 * Created on 2021/3/7.
 *
 * @author Unicorn
 */

public class JZ058_2 {
    public String reverseLeftWords(String s, int n) {
        return s.concat(s.substring(0,n)).substring(n);
    }
}
