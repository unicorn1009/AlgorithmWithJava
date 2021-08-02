package com.unicorn.大厂热题;

import com.unicorn.Leetcode.ListNode;
import com.unicorn.dataStructure.stageOne.week3.ArrayQueue;
import com.unicorn.dataStructure.stageOne.week3.Queue;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-07-24 10:48 下午
 */
public class 实现队列操作 {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.top());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.top());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println("========");
        Queue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.getFront());
        System.out.println(queue.dequeue());
        System.out.println(queue.getFront());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    static class MyQueue{

        private ListNode dummyHead;
        private ListNode tailNode;
        private int size;

        public MyQueue(){
            // 虚拟头结点
            dummyHead = new ListNode(-1);
            tailNode = dummyHead;
            size = 0;
        }

        public void push(int v){
            tailNode.next = new ListNode(v);
            tailNode = tailNode.next;
            size++;
        }

        public int top(){
            if (dummyHead.next == null)
                return -1;
            else
                return dummyHead.next.val;
        }

        public int pop(){
            if (dummyHead.next == null)
                return -1;
            else{
                if (dummyHead.next == tailNode){
                    tailNode = dummyHead;
                }
                int ret = dummyHead.next.val;
                dummyHead = dummyHead.next;
                size--;
                return ret;
            }
        }

        public int size(){
            return this.size;
        }

        public void clear(){
            dummyHead.next = null;
            tailNode = dummyHead;
            size = 0;
        }
    }
}
