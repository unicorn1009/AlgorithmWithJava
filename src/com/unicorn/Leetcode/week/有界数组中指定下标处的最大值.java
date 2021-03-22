package com.unicorn.Leetcode.week;

/**
 * <p>
 * </p>
 * Created on 2021/03/21 10:40
 *
 * @author Unicorn
 */
public class 有界数组中指定下标处的最大值 {
    public int maxValue(int n, int index, int maxSum) {

        // 第0个数从最大开始
        int maxHead = maxSum - n-1;
        int curSum = maxHead;
        int indexValue = 0;
        while (maxHead > 0){
            for (int i = 1; i <= index; i++) {
                curSum += (maxHead+1);
                if (curSum > maxSum){
                    break;
                }
            }
            indexValue = maxHead + index;
            //

            maxHead--;
        }
        return 0;
    }
}
