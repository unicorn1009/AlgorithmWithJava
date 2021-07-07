package com.unicorn.mianshijindian.链表;

import com.unicorn.Leetcode.ListNode;

/**
 * <p>
 *     面试题 02.03. 删除中间节点
 *     假定已知链表的某一个中间节点，请实现一种算法，将该节点从链表中删除。
 * </p>
 * Created on 2021/7/4.
 *
 * @author Unicorn
 */
public class MS0203 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
