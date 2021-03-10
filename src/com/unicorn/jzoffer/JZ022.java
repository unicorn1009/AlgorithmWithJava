package com.unicorn.jzoffer;

import com.unicorn.Leetcode.ListNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <p>
 *     剑指 Offer 22. 链表中倒数第k个节点
 *     输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * </p>
 * Created on 2021/3/9.
 *
 * @author Unicorn
 */

public class JZ022 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i < 6; i++) {
            ListNode node1 = new ListNode(i);
            node.next = node1;
            node = node.next;
        }
        System.out.println(head);
        System.out.println(getKthFromEnd(head, 2));
    }

    // 方法二 ： 快慢指针


    // 方法一 ： 固定长度队列
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ArrayDeque<ListNode> queue = new ArrayDeque<>();
        ListNode node = head;
        int i = 0;
        while (node != null){

            queue.addLast(node);
            i++;
            if (i > k){
                queue.removeFirst();
            }
            node = node.next;
        }
        return queue.getFirst();
    }
}
