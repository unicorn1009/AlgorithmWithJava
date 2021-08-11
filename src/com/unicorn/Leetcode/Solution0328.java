package com.unicorn.Leetcode;

import com.unicorn.niuke.排序.链表的奇偶重排;
import com.unicorn.util.ListNodeUtil;

/**
 * <p>
 *     328. 奇偶链表
 * </p>
 * Created on 2021-8-4.
 *
 * @author Unicorn
 */
public class Solution0328 {

    public static void main(String[] args) {
        System.out.println(oddEvenList(ListNodeUtil.GenListNodeByList(new int[]{1, 8, 3, 6, 5, 4, 7, 2})));
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        // 偶数链表头
        ListNode head2 = head.next;
        // 奇数节点指针头
        ListNode odd = head;
        // 偶数节点指针
        ListNode even = head2;
        // 拆分成两个链表
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = head2;
        return head;
    }
}
