package com.unicorn.大厂热题;

import com.unicorn.util.ArrayUtil;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * 739. 每日温度
 * </p>
 * Created on 2021-7-13.
 *
 * @author Unicorn
 */
public class 每日温度 {
    public static void main(String[] args) {
        ArrayUtil.printArray1D(dailyTemperatures(new int[]{34, 80, 80, 34, 34, 80, 80, 80, 80, 34}));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>(temperatures.length);
        for (int i = 0; i < temperatures.length; i++) {
            // stack不空且当前温度大于栈顶温度
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 出栈
                Integer index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }
}
