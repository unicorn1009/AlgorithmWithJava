package com.unicorn.mianshijindian.链表;

import com.unicorn.Leetcode.ListNode;

/**
 * <p>
 *     面试题 02.07. 链表相交
 *     给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
 * </p>
 * Created on 2021/7/4.
 *
 * @author Unicorn
 */
public class MS0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1 = headA;
        ListNode n2 = headB;
        // 先让一条链表走到头
        while (n1 != null && n2 != null){
            n1 = n1.next;
            n2 = n2.next;
        }
        // 走到null的指针指向另一条链表的头
        if (n1 == null){
            n1 = headB;
        }else {
            n2 = headA;
        }
        // 再次同时走, 直到其中一条走到头
        while (n1 != null && n2 != null){
            n1 = n1.next;
            n2 = n2.next;
        }
        //  走到null的指针指向另一条链表的头
        if (n1 == null){
            n1 = headB;
        }else {
            n2 = headA;
        }
        // 此时两指针距离交点的距离相同
        while (n1 != null && n2 != null){
            if (n1 == n2){
                return n1;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return null;
    }


    // 别人家孩子的代码
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        ListNode curA = headA;
        ListNode curB = headB;
        // 要么相遇即节点相等，要么都为空即无缘无分，最终都能跳出感情的死循环。
        while(curA != curB){
            // 两人以相同的速度（一次一步）沿着各自的路径走，当走完各自的路时，再“跳”至对方的路上。（起点平齐速度相同，终点即为相遇点）
            curA = (curA == null? headB:curA.next);
            curB = (curB == null? headA:curB.next);
        }
        return curA;

    }
}
