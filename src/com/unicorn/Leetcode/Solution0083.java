package com.unicorn.Leetcode;

import com.unicorn.util.ListNodeUtil;

/**
 * <p>
 * </p>
 * Created on 2021/03/26 09:15
 *
 * @author Unicorn
 */
public class Solution0083 {
    public static void main(String[] args) {
        ListNode node = ListNodeUtil.genListNodeByList(new int[]{1, 1, 2, 3, 3});
        Solution0083 solution = new Solution0083();
        System.out.println(solution.deleteDuplicates(node));

    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        while (node.next != null){
            if (node.val == node.next.val){
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
        return head;
    }
}
