package com.unicorn.Leetcode.individual;

import com.unicorn.common.Array;
import com.unicorn.util.ArrayUtil;

import java.util.Arrays;

/**
 * <p>
 *     1. 采购方案
 * </p>
 * Created on 2021/04/05 15:02
 *
 * @author Unicorn
 */
public class A {
    public static void main(String[] args) {
        System.out.println(purchasePlans(new int[]{2,2,1,9}, 10));
    }
    // 超时
    public static int purchasePlans(int[] nums, int target) {
        long ans = 0;
        Arrays.parallelSort(nums);
        int i = 0, j = nums.length -1;
        while (i < j){
            if (nums[i] + nums[j] > target){
                j--;
            }else {
               // nums[i] + nums[j] <= target
                ans += j-i;
                ans %= 1000000007;
                i++;
            }
        }

        return (int) ans;
    }


}
