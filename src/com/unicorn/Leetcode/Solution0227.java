package com.unicorn.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
    227. 基本计算器 II
    给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。整数除法仅保留整数部分。
 */
public class Solution0227 {
    public static void main(String[] args) {
        System.out.println(new Solution0227().calculate(" 1+1"));
    }
    public int calculate(String s) {
        int l = 0, r = 0;
        Deque<Integer> queueNums = new LinkedList<>();
        Deque<Character> queueChars = new LinkedList<>();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/'){
                r = i;
                String substring = s.substring(l, r).trim();
                int newNum = Integer.parseInt(substring);
                if (flag){
                    // 说明前面有一个*或/
                    // 此时需要先进行一次运算
                    Integer num1 = queueNums.removeLast();
                    Character operator = queueChars.removeLast();
                    newNum = cal(num1, newNum, operator);
                    flag = false;
                }
                queueNums.addLast(newNum);
                queueChars.addLast(s.charAt(i));
                if (i+1 < s.length())
                    l = i+1;
            }
            if (s.charAt(i) == '*' || s.charAt(i) == '/')
                flag = true;
        }
        // 还有最后一个数字未入队列
        String lastNumStr = s.substring(l, s.length()).trim();
        int lastNum = Integer.parseInt(lastNumStr);
        if (queueChars.isEmpty()) return lastNum;
        if (flag){
            Integer num1 = queueNums.removeLast();
            Character operator = queueChars.removeLast();
            lastNum = cal(num1, lastNum, operator);
        }
        queueNums.addLast(lastNum);

        // 最后从头到尾计算加减法
        while (!queueChars.isEmpty()){
            Character op = queueChars.removeFirst();
            Integer num1 = queueNums.removeFirst();
            Integer num2 = queueNums.removeFirst();
            num1 = cal(num1, num2, op);
            queueNums.addFirst(num1);
        }
        return queueNums.removeFirst();

    }

    private int cal(int num1, int num2, char op){
        if (op == '+')
            return num1+num2;
        else if (op == '-')
            return num1 - num2;
        else if (op == '*')
            return num1 * num2;
        else
            return num1 / num2;
    }
}
