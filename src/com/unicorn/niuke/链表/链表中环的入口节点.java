package com.unicorn.niuke.链表;

import com.unicorn.Leetcode.ListNode;

import java.util.*;

/**
 * <p>
 * </p>
 * Created on 2021/04/21 15:33
 *
 * @author Unicorn
 */
public class 链表中环的入口节点 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                isCycle = true;
                break;
            }
        }
        if (isCycle){
            // 如果有环,环中所有节点入哈希表
            Set<ListNode> set = new HashSet<>();
            while (!set.contains(slow)){
                set.add(slow);
                slow = slow.next;
            }
            // 从头遍历链表, 找第一个出现在哈希表中的节点
            while (!set.contains(head)){
                head = head.next;
            }
            return head;
        }
        return null;
    }
}
