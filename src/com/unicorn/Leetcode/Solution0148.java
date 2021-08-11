package com.unicorn.Leetcode;

import java.util.PriorityQueue;

/**
 * <p>
 *     148. 排序链表
 * </p>
 * Created on 2021-8-4.
 *
 * @author Unicorn
 */
public class Solution0148 {
    // 法一 : 堆排序
    public ListNode sortList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            return o1.val - o2.val;
        });
        while (head != null){
            priorityQueue.add(head);
            head = head.next;
        }
        ListNode p = dummyHead;
        while (!priorityQueue.isEmpty()){
            p.next = priorityQueue.remove();
            p = p.next;
        }
        p.next = null;
        return dummyHead.next;
    }

    // 法二 : 归并排序
    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        //利用快慢指针来找到链表的中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 归并右边
        ListNode right = mergeSort(slow.next);
        slow.next = null;   // 链表从中间断开
        // 归并左边
        ListNode left = mergeSort(head);
        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0), cur = dummyHead;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dummyHead.next;
    }

}
