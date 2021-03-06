package com.unicorn.Leetcode;

import java.util.Stack;

/**
 * <p>
 * </p>
 * Created on 2021/3/1.
 *
 * @author Unicorn
 */
public class Solution0160 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(new int[]{4, 1, 8, 4, 5});
        ListNode node2 = new ListNode(new int[]{5,0,1,8,4,5});
        System.out.println(new Solution0160().getIntersectionNode(node1,node2));

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 第一步 获取两个链表长度
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int lenA = 0, lenB = 0;
        while (nodeA != null){
            lenA+=1;
            nodeA = nodeA.next;
        }
        while (nodeB != null){
            lenB+=1;
            nodeB = nodeB.next;
        }

        if (lenA > lenB){
            // A先走
            int n = lenA - lenB;
            while (n!=0){
                headA = headA.next;
                n--;
            }
        }else if (lenB > lenA){
            // B先走
            int n = lenB - lenA;
            while (n!=0){
                headB = headB.next;
                n--;
            }
        }

        // 此时, AB链表长度相等
        while (true){
            if (headA == headB)
                return headA;
            else {
                headA = headA.next;
                headB = headB.next;
            }
        }
    }

    // 类似方法, 代码更简洁 from leetcode题解
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
