package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021-01-30.
 *
 * @author Unicorn
 */
public class Solution0019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 法一 : 使用数组存下所有结点
        ListNode r = new ListNode(-1, head);
        List<ListNode> nodes = new ArrayList<>();
        while (r.next != null){
            nodes.add(r.next);
            r = r.next;
        }
        int nodeNum = nodes.size();
        // 判断是否删除头部
        if (n == nodeNum){
            return head.next;
        }
        // 获取倒数第n+1个节点
        ListNode node = nodes.get(nodeNum - n - 1);
        node.next = node.next.next;
        return head;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {

        // 法二
        ListNode r = new ListNode(-1, head);
        int nodeNum = 0;
        while (r.next != null){
            nodeNum++;
            r = r.next;
        }
        // 判断是否删除头部
        if (n == nodeNum){
            return head.next;
        }
        // 删除第nodeNum-n+1个节点
        r = new ListNode(-1, head); // r指向头部
        int count = 1;
        while (r.next != null){
            if (count == nodeNum-n){
                r.next.next = r.next.next.next;
                break;
            }
            r = r.next;
            count++;
        }
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {

        // 法三 : 快慢指针
        ListNode fast = new ListNode(-1, head);
        ListNode low = new ListNode(-1, head);
        // 快指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast.next == null)
            return head.next;
        while (fast.next.next != null){ // 如果快指针指向的不是尾结点
            fast = fast.next;
            low = low.next;
        }
        low.next.next = low.next.next.next;

        return head;
    }
}


// Definition for singly-linked list.
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

