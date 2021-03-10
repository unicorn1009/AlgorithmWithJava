package com.unicorn.jzoffer;

import com.unicorn.Leetcode.ListNode;

import java.util.Stack;

/**
 * <p>
 *     剑指 Offer 06. 从尾到头打印链表
 *     输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * </p>
 *
 * @author unicorn
 * @create 2021-03-07 10:27 下午
 */
public class JZ006 {

    // 法二 : 不使用栈
    public int[] reversePrint1(ListNode head) {
        ListNode node = head;
        int len = 0;
        while (node != null){
            len++;
            node = node.next;
        }
        int[] ret = new int[len];
        for (int i = len-1; i>=0; i--){
            ret[i] = head.val;
            head = head.next;
        }
        return ret;
    }

    // 法1 : 使用栈
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        if (head.next == null) return new int[]{head.val};
        Stack<Integer> stack = new Stack<>();
        int len = 0;
        while (head != null){
            len++;
            stack.push(head.val);
            head = head.next;
        }
        int[] ret = new int[len];
        int i = 0;
        while (!stack.isEmpty()){
            ret[i++] = stack.pop();
        }
        return ret;
    }
}
