package com.unicorn.niuke.链表;

import com.unicorn.Leetcode.ListNode;

/**
 * <p>
 *     输入两个链表，找出它们的第一个公共结点。
 * </p>
 * Created on 2021/04/22 09:09
 *
 * @author Unicorn
 */
public class 两个链表的第一个公共节点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int x = 0;
        while (true){
            p1 = p1.next;
            if (p1 == null){
                p1 = pHead2;
                x++;
            }
            p2 = p2.next;
            if (p2 == null){
                p2 = pHead1;
                x++;
            }
            if (x == 2){
                break;
            }
        }

        while (p1 != null && p2 != null){
            if (p1 == p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
