package com.unicorn.Leetcode;

import java.util.PriorityQueue;

/**
 * <p>
 *     215. 数组中的第K个最大元素
 * </p>
 * Created on 2021/3/2.
 *
 * @author Unicorn
 */
public class Solution0215 {

    // 方法一 : 使用优先队列(默认底层实现为最小堆)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (!pq.isEmpty() && nums[i] > pq.peek()){
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
