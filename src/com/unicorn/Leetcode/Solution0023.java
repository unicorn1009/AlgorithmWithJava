package com.unicorn.Leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>
 *     23. 合并K个升序链表
 * </p>
 *
 * @author unicorn
 * @create 2021-04-03 10:29 上午
 */
public class Solution0023 {

    public ListNode mergeKLists(ListNode[] lists) {
        // 默认最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                pq.add(lists[i]);
        }
        // 伪头结点
        ListNode head = new ListNode(-1);
        ListNode i = head;
        while (!pq.isEmpty()){
            ListNode minNode = pq.remove();
            i.next = minNode;
            i = i.next;
            if (i.next != null){
                pq.add(i.next);
            }
        }
        return head.next;
    }
}
