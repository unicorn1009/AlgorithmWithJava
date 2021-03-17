package com.unicorn.jzoffer;

import com.unicorn.Leetcode.ListNode;

import java.util.Stack;

/**
 * <p>
 *     剑指 Offer 24. 反转链表
 * </p>
 * Created on 2021/3/8.
 *
 * @author Unicorn
 */
public class JZ024 {
    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node1 = node;
        for (int i = 1; i < 5; i++) {
            node1.next = new ListNode(i);
            node1 = node1.next;
        }

        System.out.println(node);
        ListNode node2 = reverseList(node);
        System.out.println(node2);


    }

    // 法二: 三指针
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode back = null;
        while (cur.next != null){
            back = cur.next;
            cur.next = pre;
            pre = cur;
            cur = back;
        }
        cur.next = pre;
        return cur;
    }


    // 法一 : 栈
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode node = head;
        while (!stack.isEmpty())
        {
            node.next = stack.pop();
            node = node.next;
        }
        node.next = null;
        return head;
    }
}
