package com.unicorn.niuke.链表;

import com.unicorn.Leetcode.ListNode;

/**
 * <p>
 *     思路 : 快慢指针
 * </p>
 * Created on 2021/04/21 15:21
 *
 * @author Unicorn
 */
public class 判断链表是否有环 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
