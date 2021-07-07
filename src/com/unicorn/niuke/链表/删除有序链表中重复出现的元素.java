package com.unicorn.niuke.链表;

import com.unicorn.Leetcode.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *     给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 * </p>
 * Created on 2021/04/26 10:40
 *
 * @author Unicorn
 */
public class 删除有序链表中重复出现的元素 {
    public ListNode deleteDuplicates (ListNode head) {
        if (head == null || head.next == null) return head;
        Set<Integer> multiNum = new HashSet<>();
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null){
            if (p2.val == p1.val){
                multiNum.add(p2.val);
            }
            p1 = p2;
            p2 = p2.next;
        }
        ListNode dummyHead = new ListNode(head.val-1);
        dummyHead.next = head;
        p1 = dummyHead;
        while (p1 != null){
            if (p1.next != null && multiNum.contains(p1.next.val)){
                p1.next = p1.next.next;
            }else {
                p1 = p1.next;
            }
        }
        return dummyHead.next;
    }

}
