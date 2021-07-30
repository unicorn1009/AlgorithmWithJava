package com.unicorn.大厂热题;

import com.unicorn.Leetcode.ListNode;
import com.unicorn.util.ListNodeUtil;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * <p>
 * </p>
 * Created on 2021-7-18.
 *
 * @author Unicorn
 */
public class K个一组翻转链表 {

    public static void main(String[] args) {
        System.out.println(reverseKGroup(ListNodeUtil.GenIncrList(2), 2));
    }

    // 栈
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        Deque<ListNode> stack = new ArrayDeque<>(k);
        ListNode pt = new ListNode(-1);
        ListNode ans = pt;
        while (p != null){
            stack.addFirst(p);
            p = p.next;

            if (stack.size() == k){
                while (!stack.isEmpty()){
                    pt.next = stack.removeFirst();
                    pt = pt.next;
                }
            }
        }
        while (!stack.isEmpty()){
            pt.next = stack.removeLast();
            pt = pt.next;
        }
        pt.next = null;
        return ans.next;
    }
}
