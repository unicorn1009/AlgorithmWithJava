package com.unicorn.mianshijindian.链表;

import com.unicorn.Leetcode.ListNode;
import com.unicorn.util.ListNodeUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *     面试题 02.01. 移除重复节点
 *     编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * </p>
 * Created on 2021/6/19.
 *
 * @author Unicorn
 */
public class MS0201 {
    public static void main(String[] args) {
        ListNode list = ListNodeUtil.GenListNodeByList(new int[]{1});
        ListNode ret = removeDuplicateNodes(list);
        System.out.println(ret);

    }
    public static ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<Integer>();
        ListNode v = new ListNode(-1, head);
        ListNode pre = v;
        ListNode node = head;
        while (node != null){
            if (!set.contains(node.val)){
                set.add(node.val);
                pre = pre.next;
                node = node.next;
            }else {
                // 已经出现过, 需删除
                pre.next = node.next;
                node = node.next;
            }
        }
        return v.next;
    }
}
