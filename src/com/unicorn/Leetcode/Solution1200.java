package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *     1200. 最小绝对差
 * </p>
 *
 * @author unicorn
 * @create 2021-04-13 10:37 下午
 */
public class Solution1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1;i < arr.length;i++){
            int temp = arr[i] - arr[i - 1];
            if (temp < minDiff){
                minDiff = temp;
                ans.clear();
            }
            //如果等于就加上
            if(temp == minDiff){
                ans.add(new ArrayList<>(Arrays.asList(arr[i-1], arr[i])));
            }
        }
        return ans;
    }
}
