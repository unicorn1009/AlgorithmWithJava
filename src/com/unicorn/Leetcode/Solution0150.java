package com.unicorn.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * </p>
 * Created on 2021/03/20 11:20
 *
 * @author Unicorn
 */
public class Solution0150 {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(new Solution0150().evalRPN(tokens));

    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> result = new ArrayDeque<>();
        Integer num2 = 0;
        Integer num1 = 0;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    num2 = result.removeFirst();
                    num1 = result.removeFirst();
                    result.addFirst(num1 + num2);
                    break;
                case "-":
                    num2 = result.removeFirst();
                    num1 = result.removeFirst();
                    result.addFirst(num1 - num2);
                    break;
                case "*":
                    num2 = result.removeFirst();
                    num1 = result.removeFirst();
                    result.addFirst(num1 * num2);
                    break;
                case "/":
                    num2 = result.removeFirst();
                    num1 = result.removeFirst();
                    result.addFirst(num1 / num2);
                    break;
                default:
                    result.addFirst(Integer.parseInt(token));
                    break;
            }
        }
        return result.peekFirst();
    }
}
