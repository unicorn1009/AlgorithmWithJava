package com.unicorn.mianshijindian.栈;

import java.util.Stack;

/**
 * <p>
 * </p>
 * Created on 2021/7/5.
 *
 * @author Unicorn
 */
public class SortedStack {

    Stack<Integer> sortedStack;
    Stack<Integer> assistStack;

    public SortedStack() {
        sortedStack = new Stack<>();
        assistStack = new Stack<>();
    }

    public void push(int val) {
        if (sortedStack.isEmpty()){
            sortedStack.push(val);
            return;
        }
        while (!sortedStack.isEmpty() && sortedStack.peek() < val){
            assistStack.push(sortedStack.pop());
        }
        sortedStack.push(val);
        while (!assistStack.isEmpty()){
            sortedStack.push(assistStack.pop());
        }
    }

    public void pop() {
        if (!isEmpty())
            sortedStack.pop();
    }

    public int peek() {
        if (!isEmpty())
            return sortedStack.peek();
        else
            return -1;
    }

    public boolean isEmpty() {
        return sortedStack.isEmpty();
    }
}
