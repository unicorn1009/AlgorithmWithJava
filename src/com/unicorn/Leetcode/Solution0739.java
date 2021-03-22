package com.unicorn.Leetcode;

import com.unicorn.util.ArrayUtil;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 *     739. 每日温度
 * </p>
 * Created on 2021/03/22 18:41
 *
 * @author Unicorn
 */
public class Solution0739 {
    public static void main(String[] args) {
        int[] arr =  {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperatures = new Solution0739().dailyTemperatures(arr);
        ArrayUtil.printArray1D(temperatures);
    }
    public int[] dailyTemperatures(int[] nums) {
        Deque<Integer> indexStack = new ArrayDeque<>();
        int[] ans = new int[nums.length];
        for (int i = nums.length-1; i >= 0; i--) {
            while (!indexStack.isEmpty() && nums[indexStack.peekFirst()] <= nums[i]){
                indexStack.removeFirst();
            }
            ans[i] = indexStack.isEmpty() ? 0 : indexStack.peekFirst() - i;
            indexStack.push(i);
        }
        return ans;
    }
}
