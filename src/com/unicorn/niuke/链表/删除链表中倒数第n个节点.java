package com.unicorn.niuke.链表;

import com.unicorn.Leetcode.ListNode;

/**
 * <p>
 * </p>
 * Created on 2021/04/21 15:46
 *
 * @author Unicorn
 */
public class 删除链表中倒数第n个节点 {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        if (head == null) return null;
        ListNode p = head;
        // P先走n+1步
        while (n >= 0){
            if (p == null){
                return head.next;
            }
            p = p.next;
            n--;
        }
        ListNode p2 = head;
        while (p != null){
            p = p.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return head;
    }
}
