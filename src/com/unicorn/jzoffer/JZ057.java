package com.unicorn.jzoffer;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *     剑指 Offer 57. 和为 s 的两个数字
 *     输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * </p>
 * Created on 2021/3/3.
 *
 * @author Unicorn
 */
public class JZ057 {

    // 法二 : 利用数组有序特性, 使用双指针
    public int[] twoSum2(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (true){
            int cur = nums[l] + nums[r];
            if (cur > target){
                r--;
            }else if (cur < target){
                l++;
            }else {
                break;
            }
        }
        return new int[]{nums[l] , nums[r]};
    }

    // 法一 : 使用额外辅助集合保存历史数据
    public int[] twoSum1(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                ret[0] = target-nums[i];
                ret[1] = nums[i];
                break;
            }else {
                set.add(target-nums[i]);
            }
        }
        return ret;
    }
}
