package com.unicorn.jzoffer;

/**
 * <p>
 *     剑指 Offer 53 - I. 在排序数组中查找数字 I
 *     统计一个数字在排序数组中出现的次数。
 * </p>
 * Created on 2021/3/2.
 *
 * @author Unicorn
 */
public class JZ053_1 {

    // 方法二 : 二分查找, 一看到数组有序, 首先应该想到二分法 O(logn)
    public int search2(int[] nums, int target) {
        //TODO 剑指 Offer 53 - I. 在排序数组中查找数字 I
        return 0;
    }

    // 方法一 : 顺序扫描 时间复杂度为O(n)
    public int search1(int[] nums, int target) {
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                count++;
                flag = true;
            }
            if (flag == true && nums[i] != target)
                break;
        }

        return count;
    }

}
