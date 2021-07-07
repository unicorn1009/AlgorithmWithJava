package com.unicorn.niuke.链表;

import com.unicorn.Leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/04/22 09:36
 *
 * @author Unicorn
 */
public class 两个链表生成相加链表 {
    public ListNode addInList (ListNode head1, ListNode head2) {
        // 先反转两个链表
        ListNode newHead1 = reverseList(head1);
        ListNode newHead2 = reverseList(head2);
        // 做加法
        List<Integer> nums = new ArrayList<>();
        boolean isCarry = false;
        while (newHead1 != null && newHead2 != null){
            int cur = isCarry ? newHead1.val + newHead2.val + 1 : newHead1.val + newHead2.val;
            if (cur >= 10){
                isCarry = true;
                nums.add(cur % 10);
            }else {
                isCarry = false;
                nums.add(cur);
            }
            newHead1 = newHead1.next;
            newHead2 = newHead2.next;
        }
        while (newHead1 != null){
            int cur = isCarry ? newHead1.val + 1 : newHead1.val;
            if (cur >= 10){
                isCarry = true;
                nums.add(cur % 10);
            }else {
                isCarry = false;
                nums.add(cur);
            }
            newHead1 = newHead1.next;
        }
        while (newHead2 != null){
            int cur = isCarry ? newHead2.val + 1 : newHead2.val;
            if (cur >= 10){
                isCarry = true;
                nums.add(cur % 10);
            }else {
                isCarry = false;
                nums.add(cur);
            }
            newHead2 = newHead2.next;
        }
        if (isCarry){
            nums.add(1);
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        int len = nums.size();
        for (int i = 0; i < len; i++) {
            Integer cur = nums.get(len - i - 1);
            p.next = new ListNode(cur);
            p = p.next;
        }
        return dummyHead.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
