package com.unicorn.niuke.链表;

import com.unicorn.Leetcode.ListNode;
import com.unicorn.util.ListNodeUtil;

/**
 * <p>
 * </p>
 * Created on 2021/04/26 09:50
 *
 * @author Unicorn
 */
public class 链表内指定区间反转 {
    public static void main(String[] args) {
        ListNode node = ListNodeUtil.genIncrList(5);
        reverseBetween(node, 1, 3);
    }
    public static ListNode reverseBetween (ListNode head, int m, int n) {
        int x = m;
        int count = n-m;
        if (count == 0) return head;
        ListNode prePre = null;
        ListNode curr = head;
        while (m > 1){
            prePre = curr;
            curr = curr.next;
            m--;
        }
        ListNode tail = curr;

        ListNode prev = null;
        curr = prePre == null ? head : prePre.next;
        while (curr != null && count >= 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count--;
        }
        if (prePre != null)
            prePre.next = prev;
        if (tail != null)
            tail.next = curr;

        return x == 1 ? prev : head;
    }
}
