package com.unicorn.jzoffer;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>
 *     剑指 Offer 58 - I. 翻转单词顺序
 *     输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * </p>
 * Created on 2021/3/7.
 *
 * @author Unicorn
 */

public class JZ058_1 {
    public static void main(String[] args) {
        reverseWords("a good   example");
    }
    public static String reverseWords(String s) {
        if (s.trim().isEmpty()) return "";
        Stack<String> stack = new Stack<>();
        StringBuffer stringBuffer = new StringBuffer();
        String[] strings = s.trim().split(" ");
        for (String string : strings) {
            if (!string.trim().isEmpty()){
                stack.push(string.trim());
            }
        }
        while (!stack.isEmpty()){
            stringBuffer.append(stack.pop());
            stringBuffer.append(" ");
        }
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        return stringBuffer.toString();
    }
}
