package com.unicorn.Leetcode;

import java.util.*;

/**
 * <p>
 * </p>
 * Created on 2021/04/05 22:28
 *
 * @author Unicorn
 */
public class Solution1512 {
    public static void main(String[] args) {
        System.out.println(new Solution1512().numIdenticalPairs1(new int[]{1, 2, 3, 4}));
    }
    public int numIdenticalPairs1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else {
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        int ans = 0;
        Collection<Integer> values = map.values();
        for (Integer value : values) {
            ans += cmn(value,2);
        }
        return ans;
    }

    // 计算组合数
    private int cmn(int m,int n){
        if(n < 0 || m < n)
            return 0;
        if(m==n)
            return 1;
        if(n==1)
            return m;
        return cmn(m-1,n)+cmn(m-1,n-1);
    }
}
