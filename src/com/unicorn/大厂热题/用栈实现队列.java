package com.unicorn.大厂热题;

import java.util.Stack;

/**
 * <p>
 *     232. 用栈实现队列
 *     请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * </p>
 * Created on 2021-7-23.
 *
 * @author Unicorn
 */
public class 用栈实现队列 {


    class MyQueue {

        private int size;

        private Stack<Integer> inQueue;
        private Stack<Integer> outQueue;

        /** Initialize your data structure here. */
        public MyQueue() {
            inQueue  = new Stack<>();
            outQueue = new Stack<>();
            size=0;
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            inQueue.push(x);
            size++;
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (!outQueue.isEmpty()){
                size--;
                return outQueue.pop();
            }else {
                // 出栈空
                if (inQueue.isEmpty())  // 入栈也空
                    return -1;
                else {  // 入栈不空
                    while (!inQueue.isEmpty()) {
                        outQueue.push(inQueue.pop());
                    }
                    return pop();
                }
            }
        }

        /** Get the front element. */
        public int peek() {
            if (!outQueue.isEmpty()){
                return outQueue.peek();
            }else {
                // 出栈空
                if (inQueue.isEmpty())  // 入栈也空
                    return -1;
                else {  // 入栈不空
                    while (!inQueue.isEmpty()) {
                        outQueue.push(inQueue.pop());
                    }
                    return peek();
                }
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return size == 0;
        }
    }
}
