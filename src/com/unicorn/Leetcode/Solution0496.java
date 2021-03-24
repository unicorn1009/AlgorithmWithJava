package com.unicorn.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     496. 下一个更大元素 I
 * </p>
 * Created on 2021/03/22 19:14
 *
 * @author Unicorn
 */
public class Solution0496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekFirst() <= nums2[i]){
                stack.removeFirst();
            }
            int v = stack.isEmpty() ? -1 : stack.peekFirst();
            map.put(nums2[i], v);
            stack.addFirst(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}
