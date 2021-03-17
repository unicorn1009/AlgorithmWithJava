package com.unicorn.jzoffer;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <p>
 * </p>
 * Created on 2021/3/17 0017
 *
 * @author Unicorn
 */
public class JZ050 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar1("aabb"));
    }

    // 更快
    public static char firstUniqChar1(String s) {
        int len = s.length();
        if (len == 0) return ' ';
        int[] nums = new int[26];

        // 初始全为0
        // 只要重复出现即置为-1

        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            if (nums[index] == 0){
                // 第一次出现
                nums[index] = len - i;
            }else {
                // 已经出现过
                nums[index] = -1;
            }
        }
        int ret = -1;
        for (int num : nums) {
            ret = Math.max(num, ret);
        }
        if (ret == -1 || ret == 0)
            return ' ';
        else
            return s.charAt(len - ret);
    }

    public static char firstUniqChar(String s) {
        int len = s.length();
        if (len == 0) return ' ';
        int[] nums = new int[26];
        for (int i = 0; i < 26; i++) {
            nums[i] = len;
        }

        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            if (nums[index] == len){
                // 第一次出现
                nums[index] = i;
            }else {
                // 已经出现过
                nums[index] = len+1;
            }
        }
        int ret = len;
        for (int num : nums) {
            ret = Math.min(num, ret);
        }
        if (ret == len)
            return ' ';
        else
            return s.charAt(ret);
    }


}
