package com.unicorn.util;

import com.unicorn.Leetcode.ListNode;

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
}
