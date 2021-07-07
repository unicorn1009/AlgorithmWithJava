package com.unicorn.mianshijindian.栈;

import java.util.Stack;

/**
 * <p>
 *     面试题 03.04. 化栈为队
 *     实现一个MyQueue类，该类用两个栈来实现一个队列。
 * </p>
 * Created on 2021/7/4.
 *
 * @author Unicorn
 */
public class MS0304 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue.empty());
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}

// 思路, 一个栈入, 一个栈出
class MyQueue {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // 只进入栈
        stackIn.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stackOut.isEmpty()){
            // 出栈空时, 从入栈倒入
            while (!stackIn.isEmpty()){
                stackOut.add(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stackOut.isEmpty()){
            // 出栈空时, 从入栈倒入
            while (!stackIn.isEmpty()){
                stackOut.add(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}