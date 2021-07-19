package com.unicorn.mianshijindian.栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * </p>
 * Created on 2021/7/4.
 *
 * @author Unicorn
 */
public class MS0302 {
    public static void main(String[] args) {

    }

    
}

class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.addLast(x);
        if (minStack.isEmpty() || x <= minStack.peekLast()){
            minStack.addLast(x);
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        Integer last = stack.removeLast();
        if (last.equals(minStack.peekLast())){
            minStack.removeLast();
        }
    }

    public int top() {
        if (stack.isEmpty())
            return Integer.MIN_VALUE;
        return stack.peekLast();
    }

    public int getMin() {
        if (minStack.isEmpty())
            return Integer.MIN_VALUE;
        return minStack.peekLast();
    }
}
