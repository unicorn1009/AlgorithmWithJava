package com.unicorn.jzoffer;

import com.unicorn.Leetcode.ListNode;

/**
 * <p>
 *     剑指 Offer 25. 合并两个排序的链表
 * </p>
 * Created on 2021/3/8.
 *
 * @author Unicorn
 */
public class JZ025 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null;
        if (l1.val <= l2.val){
            head = l1;
            l1 = l1.next;
        }else {
            head = l2;
            l2 = l2.next;
        }
        ListNode node = head;
        while (true){
            if (l1 == null || l2 == null) break;
            if (l1.val <= l2.val){
                node.next = l1;
                l1 = l1.next;
            }else{
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 == null){
            node.next = l2;
            return head;
        }
        node.next = l1;
        return head;
    }
}
