package com.unicorn.niuke.链表;

import com.unicorn.Leetcode.ListNode;

/**
 * <p>
 *     输入一个链表，反转链表后，输出新链表的表头。
 * </p>
 * Created on 2021/04/20 15:38
 *
 * @author Unicorn
 */
public class 反转链表 {
    // 递归
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode node = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    // 非递归
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
