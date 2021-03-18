package com.unicorn.Leetcode;

import com.unicorn.util.ListNodeUtil;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 *     92. 反转链表 II
 *     反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *     1 ≤ m ≤ n ≤ 链表长度。
 * </p>
 * Created on 2021/3/18.
 *
 * @author Unicorn
 */
public class Solution0092 {
    public static void main(String[] args) {
        ListNode node = ListNodeUtil.genIncrList(5);
        ListNode node1 = reverseBetween(node, 2, 4);
        System.out.println(node1);
    }

    // 只反转val
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) return head;
        ListNode node1 = head;
        ListNode node2 = head;
        int move = left;
        while (left > 1){
            node1 = node1.next;
            node2 = node2.next;
            left--;
        }
        // node1停在反转的头部
        Deque<Integer> stack = new ArrayDeque<>();
        while (move <= right){
            stack.addFirst(node2.val);
            node2 = node2.next;
            move++;
        }
        while (!stack.isEmpty()){
            node1.val = stack.removeFirst();
            node1 = node1.next;
        }
        return head;
    }
}
