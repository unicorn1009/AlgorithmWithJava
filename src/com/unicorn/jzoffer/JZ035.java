package com.unicorn.jzoffer;

import com.unicorn.Leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     剑指 Offer 35. 复杂链表的复制
 * </p>
 * Created on 2021/03/26 09:48
 *
 * @author Unicorn
 */
public class JZ035 {
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (head.next == null){
            Node node = new Node(head.val);
            if (head.random != null)
                node.random = node;
            return node;
        }
        Node newHead = new Node(-1);
        Node newPoint = newHead;  // 新链表的指针
        Node oldPoint = head;     // 旧链表的指针
        int count = 0;
        // 先复制next
        while (oldPoint != null){
            Node newNode = new Node(oldPoint.val);
            newNode.random = oldPoint;
            newPoint.next = newNode;

            Node oldNext = oldPoint.next;
            oldPoint.next = newNode;

            newPoint = newPoint.next;
            oldPoint = oldNext;
            count++;

        }
        Node[] nodes = new Node[count];
        count = 0;
        // 复制random
        newPoint = newHead.next;
        while (newPoint != null){
            nodes[count++] = newPoint.random;
            if (newPoint.random.random == null){
                newPoint.random = null;
            }else {
                newPoint.random = newPoint.random.random.next;
            }

            newPoint = newPoint.next;
        }

        for (int i = 1; i < count; i++) {
            nodes[i-1].next = nodes[i];
            nodes[i].next = null;
        }
        return newHead.next;
    }
}


