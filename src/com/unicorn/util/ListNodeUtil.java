package com.unicorn.util;

import com.unicorn.Leetcode.ListNode;

import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/3/18.
 *
 * @author Unicorn
 */
public class ListNodeUtil {
    public static void main(String[] args) {
        ListNode node = genIncrList(10);
        System.out.println(node);
    }

    /**
     * 生成递增链表
     * @param n 链表长度
     * @return
     */
    public static ListNode genIncrList(int n){
        if (n == 0) return null;
        ListNode root = new ListNode(1);
        ListNode node = root;
        for (int i = 2; i <= n; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return root;
    }

    public static ListNode genListNodeByList(int[] arr){
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode p = head;
        for (int i = 1; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        return head;
    }
}
