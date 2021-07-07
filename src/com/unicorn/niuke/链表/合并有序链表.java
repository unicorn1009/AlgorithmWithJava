package com.unicorn.niuke.链表;

import com.unicorn.Leetcode.ListNode;

/**
 * <p>
 * </p>
 * Created on 2021/04/20 15:47
 *
 * @author Unicorn
 */
public class 合并有序链表 {
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 == null) p.next = l2;
        if (l2 == null) p.next = l1;

        return dummyHead.next;
    }
}
