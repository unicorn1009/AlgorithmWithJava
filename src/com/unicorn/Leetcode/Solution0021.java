package com.unicorn.Leetcode;

/**
 * <p>
 *     21. 合并两个有序链表
 *     将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * </p>
 * Created on 2021-01-27.
 *
 * @author Unicorn
 */
public class Solution0021 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // l1 l2 均不少于两个节点
        ListNode head = new ListNode(-1);
        ListNode cursor = head;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                cursor.next = l1;
                l1 = l1.next;
            }else {
                cursor.next = l2;
                l2 = l2.next;
            }
            cursor = cursor.next;
        }
        if (l1 == null) cursor.next = l2;
        if (l2 == null) cursor.next = l1;

        return head.next;
    }
}

