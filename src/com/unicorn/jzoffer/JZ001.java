package com.unicorn.jzoffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 *     面试题30. 包含min函数的栈
 * </p>
 * Created on 2021/03/26 09:36
 *
 * @author Unicorn
 */
public class JZ001 {
}

class MinStack {
    Deque<Integer> dataStack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        dataStack.addFirst(x);
        if (minStack.isEmpty() || minStack.peekFirst() >= x){
            minStack.addFirst(x);
        }
    }

    public void pop() {
        int popNum = dataStack.removeFirst();
        if (!minStack.isEmpty() && popNum == minStack.peekFirst()){
            minStack.removeFirst();
        }

    }

    public int top() {
        if (dataStack.isEmpty())
            throw new RuntimeException("栈空");
       return dataStack.peekFirst();
    }

    public int min() {
        if (minStack.isEmpty())
            throw new RuntimeException("栈空");
        return minStack.peekFirst();
    }
}