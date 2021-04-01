package com.unicorn.mianshijindian;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     面试题 16.26. 计算器
 * </p>
 * Created on 2021/04/01 20:01
 *
 * @author Unicorn
 */
public class MS1626 {
    public static void main(String[] args) {
        System.out.println(calculate("3+2*2*4/3+7-4/2+6"));
    }
    public static int calculate(String s) {
        // 双栈方案
        Deque<Character> optStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();

        // 定义优先级
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('-', 1);
            put('+', 1);
            put('*', 2);
            put('/', 2);
        }};

        int curNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (Character.isDigit(curChar)){
                curNum = curNum*10 + (curChar - '0');
            }else if (curChar == '+' || curChar == '-' || curChar == '*' || curChar == '/'){
                numStack.addFirst(curNum);
                curNum = 0;
                while (!optStack.isEmpty() && map.get(optStack.peekFirst()) >= map.get(curChar)){
                    Integer num2 = numStack.removeFirst();
                    Integer num1 = numStack.removeFirst();
                    Character opt = optStack.removeFirst();
                    calc(numStack, opt, num2, num1);
                }
                optStack.addFirst(curChar);
            }
        }
        numStack.addFirst(curNum);
        while (!optStack.isEmpty()) {
            Character opt = optStack.removeFirst();
            Integer num2 = numStack.removeFirst();
            Integer num1 = numStack.removeFirst();
            calc(numStack, opt, num2, num1);
        }
        return numStack.peekFirst();
    }

    private static void calc(Deque<Integer> numStack, Character opt, Integer num2, Integer num1) {
        switch (opt) {
            // 遇到加减时,先把栈内的优先级高的算了
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
