package com.unicorn.Leetcode;

import java.util.PriorityQueue;

/**
 * <p>
 *     703. 数据流中的第 K 大元素
 * </p>
 *
 * @author unicorn
 * @create 2021-07-26 10:51 下午
 */
public class Solution0703 {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{5,-1});
        System.out.println(kthLargest.add(2));
        System.out.println(kthLargest.add(1));
        System.out.println(kthLargest.add(-1));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(3));
    }


    static class KthLargest {

        int k;
        // 小顶堆,保存最大的k个数
        PriorityQueue<Integer> minValues = new PriorityQueue<>();;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i = 0; i < nums.length; i++) {
                if (minValues.size() < k){
                    minValues.add(nums[i]);
                }else {
                    if (nums[i] >= minValues.peek()){
                        minValues.add(nums[i]);
                        minValues.remove();
                    }
                }
            }

        }

        public int add(int val) {
            if (minValues.size() < k) {
                minValues.add(val);
                return minValues.peek();
            }
            if (val >= minValues.peek()){
                minValues.add(val);
                minValues.remove();
            }
            return minValues.peek();

        }
    }
}
