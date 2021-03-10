package com.unicorn.jzoffer;

import com.unicorn.Leetcode.ListNode;

/**
 * <p>
 *     剑指 Offer 18. 删除链表的节点
 * </p>
 * Created on 2021/3/9.
 *
 * @author Unicorn
 */
public class JZ018 {
    public static void main(String[] args) {

    }
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode node = head;
        while (node.next != null){
            if (node.next.val == val) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return head;
    }

}
