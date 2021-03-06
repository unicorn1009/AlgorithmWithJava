package com.unicorn.Leetcode;

import com.unicorn.common.Array;

import java.util.Arrays;

/**
 * <p>
 *     1011. 在 D 天内送达包裹的能力
 *      传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *      传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *      返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 *      思路 : 二分查找的变种, 关键是挖掘出问题的单调性

 * </p>
 * Created on 2021/2/25.
 *
 * @author Unicorn
 */
public class Solution1011 {
    public static void main(String[] args) {
        System.out.println(new Solution1011().shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }
    public int shipWithinDays(int[] weights, int D) {
        int l = 0, r = 0;
        for (int weight : weights) {
            if (weight > l) l = weight;
            r+=weight;
        }
        while (l < r){
            int mid = l + (r-l)/2;
            int time = timeConsuming(weights, mid);
            if (time <= D){
                r = mid;
            }else {
                l = mid+1;
            }
        }
        return l;
    }

    private int timeConsuming(int[] weights, int maxLoad) {
        int res = 0;
        int load = 0;
        for (int weight : weights) {
            load += weight;
            if (load > maxLoad){
                res += 1;
                load = weight;
            }else if (load == maxLoad){
                res += 1;
                load = 0;
            }
        }
        if (load > 0) res += 1;
        return res;
    }
}
