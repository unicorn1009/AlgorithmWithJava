package com.unicorn;

import com.unicorn.common.ArrayStack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        for (int i = 0; i < 5; i++) {
            System.out.println(stack.pop());
        }
    }
}
