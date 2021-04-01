package com.unicorn.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * </p>
 * Created on 2021/04/01 20:54
 *
 * @author Unicorn
 */
public class Solution0224 {
    public static void main(String[] args) {
        System.out.println(new Solution0224().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
    public int calculate(String s) {
        if(s.length() == 1 && s.charAt(0) == '0') return 0;
        // 双栈
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Character> optStack = new ArrayDeque<>();

        char preChar = ' ';
        int curNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (Character.isDigit(curChar)){
                curNum = curNum * 10 + (curChar - '0');
                preChar = curChar;
            }else if (curChar == '('){
                optStack.addFirst(curChar);
                preChar = curChar;
            }else if (curChar == ')'){
                if (preChar != ')') {
                    numStack.addFirst(curNum);
                    curNum = 0;
                }
                while (!optStack.isEmpty() && optStack.peekFirst() != '('){
                    calc(numStack, optStack);
                }
                optStack.removeFirst();     // 扔掉左括号
                preChar = curChar;
            }else if (curChar == '+' || curChar == '-'){
                // + 或 -
                if (preChar != ')'){
                    numStack.addFirst(curNum);
                    curNum = 0;
                }
                while (!optStack.isEmpty() && (optStack.peekFirst() == '+' || optStack.peekFirst() == '-')){
                    calc(numStack, optStack);
                }
                optStack.addFirst(curChar);
                preChar = curChar;
            }
        }
        if (preChar != ')')
            numStack.addFirst(curNum);
        while (!optStack.isEmpty()){
            calc(numStack, optStack);
        }
        return numStack.peekFirst();
    }

    private void calc(Deque<Integer> numStack, Deque<Character> optStack) {
        Integer num2 = numStack.removeFirst();
        Integer num1 = numStack.removeFirst();
        Character opt = optStack.removeFirst();
        switch (opt){
            case '+':
                numStack.addFirst(num1 + num2);
                break;
            case '-':
                numStack.addFirst(num1 - num2);
                break;
        }
    }
}
