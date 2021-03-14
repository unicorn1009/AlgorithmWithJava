package com.unicorn.jzoffer;

/**
 * <p>
 *     剑指 Offer 59 - I. 滑动窗口的最大值
 * </p>
 * Created on 2021/3/10.
 *
 * @author Unicorn
 */

import java.util.*;

public class JZ059_1 {
    public static void main(String[] args) {
        int[] nums = {-7,-8,7,5,7,1,6,0};
        int[] ints = maxSlidingWindow1(nums, 4);
        System.out.println(Arrays.toString(ints));
    }

    // 单调队列
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int len = nums.length;
        if(len == 0 || k == 0) return new int[0];
        int[] ret = new int[len-k+1];
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            while(!queue.isEmpty() && queue.peekLast() < nums[i])
                queue.removeLast();
            queue.addLast(nums[i]);
        }

        ret[0] = queue.peekFirst();
        for (int i = k; i < len; i++) {
            // 需要滑出一个元素
            if (queue.peekFirst() == nums[i-k]){
                queue.removeFirst();
            }

            while (!queue.isEmpty() && queue.peekLast() < nums[i]){
                queue.removeLast();
            }
            queue.addLast(nums[i]);

            ret[i - k + 1] = queue.peekFirst();
        }
        return ret;
    }

    // 优先队列（最大堆） 复杂度很高
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
