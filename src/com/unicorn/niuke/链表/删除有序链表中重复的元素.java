package com.unicorn.niuke.链表;

import com.unicorn.Leetcode.ListNode;

/**
 * <p>
 *     删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
 * </p>
 * Created on 2021/04/26 10:35
 *
 * @author Unicorn
 */
public class 删除有序链表中重复的元素 {
    public ListNode deleteDuplicates (ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        while (p != null){
            if (p.next != null && p.next.val == p.val){
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }
        return head;
    }
}
