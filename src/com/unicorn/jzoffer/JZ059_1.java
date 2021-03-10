package com.unicorn.jzoffer;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class JZ059_1 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int[] ans = new int[nums.length-k+1];
        int j = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            ans[j++] = pq.peek();
            pq.add(nums[i]);
            pq.remove(nums[i-k]);
        }
        ans[j] = pq.peek();
        return ans;
    }
}
