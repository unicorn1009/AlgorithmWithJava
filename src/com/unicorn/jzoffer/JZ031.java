package com.unicorn.jzoffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * </p>
 * Created on 2021/03/29 15:12
 *
 * @author Unicorn
 */
public class JZ031 {
    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{8,9,2,3,7,0,5,4,6,1}, new int[]{6,8,2,1,3,9,0,7,4,5}));
    }

    // 我写的
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0, j = 0;
        while (true) {
            while ((stack.isEmpty() && (i < pushed.length)) || (!stack.isEmpty() && stack.peekFirst() != popped[j])) {
                if (i < pushed.length)
                    stack.addFirst(pushed[i++]);
                else
                    break;
            }
            while (!stack.isEmpty() && stack.peekFirst() == popped[j]) {
                stack.removeFirst();
                j++;
            }
            if (!stack.isEmpty() && stack.peekFirst() != popped[j] && i == pushed.length)
                return false;
            if (stack.isEmpty() && i == pushed.length && j == pushed.length) {
                return true;
            }
        }

    }

    // Leetcode精选, 思想一样, 但更简洁
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

}
