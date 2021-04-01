package com.unicorn.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     1006. 笨阶乘
 * </p>
 * Created on 2021/04/01 22:06
 *
 * @author Unicorn
 */
public class Solution1006 {
    public static void main(String[] args) {
        System.out.println(clumsy(20));
    }
    public static int clumsy(int N) {
        // 双栈
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Character> optStack = new ArrayDeque<>();

        // 定义优先级
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('-', 1);
            put('+', 1);
            put('*', 2);
            put('/', 2);
        }};

        char[] opts = new char[]{'*', '/', '+', '-'};
        int j = 0;
        for (int i = N; i > 1; i--) {
            numStack.addFirst(i);
            char opt = opts[j % 4];
            while (!optStack.isEmpty() && map.get(optStack.peekFirst()) >= map.get(opt)){
                // 先算栈内的
                calcu(numStack, optStack);
            }
            optStack.addFirst(opt);
            j++;
        }
        numStack.addFirst(1);
        while (!optStack.isEmpty()){
            calcu(numStack, optStack);
        }
        return numStack.peekFirst();
    }

    private static void calcu(Deque<Integer> numStack, Deque<Character> optStack) {
        Character operator = optStack.removeFirst();
        Integer num2 = numStack.removeFirst();
        Integer num1 = numStack.removeFirst();
        switch (operator){
            case '+':
                numStack.addFirst(num1 + num2);
                break;
            case '-':
                numStack.addFirst(num1 - num2);
                break;
            case '*':
                numStack.addFirst(num1 * num2);
                break;
            case '/':
                numStack.addFirst(num1 / num2);
                break;
        }
    }
}
