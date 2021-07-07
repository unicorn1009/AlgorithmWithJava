package com.unicorn.mianshijindian.字符串;

/**
 * <p>
 * 面试题 01.05. 一次编辑
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * </p>
 * Created on 2021/6/17.
 *
 * @author Unicorn
 */
public class MS0105 {
    public static void main(String[] args) {
        System.out.println(oneEditAway("ab", "abc"));
    }
    public static boolean oneEditAway(String first, String second) {
        // 插入和删除是同类操作, 可统一
        if (first.length() == second.length()) {
            // 长度相等, 只有替换字符的可能
            int c = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    c++;
                }
                if (c > 1) {
                    return false;
                }
            }
            return true;
        } else if (Math.abs(first.length() - second.length()) == 1) {
            // 如果长度不等, 必定是长的删除一个
            // 找到第一个不相同的字符, 其后字符必须相同
            String longStr;
            String shortStr;
            if (first.length() > second.length()) {
                longStr = first;
                shortStr = second;
            }else {
                longStr = second;
                shortStr = first;
            }
            if (shortStr.length()==0){
                return true;
            }
            for (int i = 0; i < shortStr.length(); i++) {
                if (longStr.charAt(i)!= shortStr.charAt(i)) {
                    for (int j = i+1; j < longStr.length(); j++) {
                        if (longStr.charAt(j) != shortStr.charAt(j-1)){
                            return false;
                        }
                    }
                    return true;
                }
            }

        } else {
            return false;
        }
        return true;
    }
}
