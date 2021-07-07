package com.unicorn.niuke.链表;

import com.unicorn.Leetcode.ListNode;

/**
 * <p>
 *     输入一个链表，输出该链表中倒数第k个结点。
 *      如果该链表长度小于k，请返回空。
 * </p>
 * Created on 2021/04/26 11:02
 *
 * @author Unicorn
 */
public class 链表中倒数第k个结点 {
    public ListNode FindKthToTail (ListNode pHead, int k) {

        ListNode dummyHead = new ListNode(-1, pHead);
        ListNode fast = dummyHead, slow = dummyHead;
        // 快指针先走k步
        while (k > 0){
            fast = fast.next;
            k--;
            if (fast == null){
                return null;
            }
        }
        // 快慢同时走,直到快指针走到null
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
