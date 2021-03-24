package com.unicorn.Leetcode;

/**
 * <p>
 *     24. 两两交换链表中的节点
 * </p>
 * Created on 2021/03/23 08:51
 *
 * @author Unicorn
 */
public class Solution0024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        ListNode nextHead = swapPairs(newHead.next);
        head.next = nextHead;
        newHead.next = head;
        return newHead;
    }

}
