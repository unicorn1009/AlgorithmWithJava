package com.unicorn.mianshijindian.栈;

import com.unicorn.Leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 *     面试题 03.03. 堆盘子
 * </p>
 * Created on 2021/7/4.
 *
 * @author Unicorn
 */
public class StackOfPlates {
    public static void main(String[] args) {
        StackOfPlates stackOfPlates = new StackOfPlates(3);
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.popAt(1));
        stackOfPlates.push(1);
        System.out.println(stackOfPlates.popAt(2));
        System.out.println(stackOfPlates.popAt(2));
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());
        stackOfPlates.push(9);
        System.out.println(stackOfPlates.popAt(3));
        System.out.println(stackOfPlates.pop());
        stackOfPlates.push(51);
        stackOfPlates.push(20);
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.popAt(2));
        System.out.println(stackOfPlates.popAt(0));
        stackOfPlates.push(35);
        stackOfPlates.push(1);
        stackOfPlates.push(19);
        System.out.println(stackOfPlates.popAt(3));
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.popAt(1));
        System.out.println(stackOfPlates.pop());
        stackOfPlates.push(36);
        System.out.println(stackOfPlates.popAt(1));
        stackOfPlates.push(19);
        stackOfPlates.push(3);
        System.out.println(stackOfPlates.popAt(3));
        stackOfPlates.push(15);
        stackOfPlates.push(44);
        System.out.println(stackOfPlates.pop());

    }
    List<Stack<Integer>> stackList;
    int cap;
    public StackOfPlates(int cap) {
        if (cap > 0){
            stackList = new ArrayList<>();
            this.cap = cap;
        }
    }

    public void push(int val) {
        if (stackList == null)
            return;
        if (stackList.isEmpty())
            stackList.add(new Stack<>());
        Stack<Integer> lastStack = stackList.get(stackList.size() - 1);
        if (lastStack.size() >= cap){
            Stack<Integer> newStack = new Stack<>();
            newStack.add(val);
            stackList.add(newStack);
        }else
            lastStack.push(val);
    }

    public int pop() {
        if (stackList == null)
            return -1;
        if (stackList.isEmpty()){
            return -1;
        }
        Stack<Integer> lastStack = stackList.get(stackList.size() - 1);
        int ret = lastStack.pop();
        if (lastStack.isEmpty()){
            stackList.remove(stackList.size() - 1);
        }
        return ret;
    }

    public int popAt(int index) {
        if (stackList == null)
            return -1;
        if (index < 0 || index > stackList.size()-1){
            return -1;
        }
        Stack<Integer> stack = stackList.get(index);
        Integer ret = stack.pop();
        if (stack.isEmpty()){
            stackList.remove(index);
        }
        return ret;
    }
}
