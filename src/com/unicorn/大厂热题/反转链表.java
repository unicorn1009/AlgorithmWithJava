package com.unicorn.大厂热题;

import com.unicorn.Leetcode.ListNode;
import com.unicorn.util.ListNodeUtil;

/**
 * <p>
 * </p>
 * Created on 2021-7-18.
 *
 * @author Unicorn
 */
public class 反转链表 {
    public static void main(String[] args) {
        System.out.println(reverseList(ListNodeUtil.GenIncrList(2)));
    }
    // 三指针
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = null;
        ListNode p2 = head;
        ListNode p3 = head.next;
        while (p3 != null){
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 =p3.next;
        }
        p2.next = p1;
        return p2;
    }
}
