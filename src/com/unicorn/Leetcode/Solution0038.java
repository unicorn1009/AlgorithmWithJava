package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     38. 外观数列
 *     给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * </p>
 * Created on 2021/03/20 10:23
 *
 * @author Unicorn
 */
public class Solution0038 {
    public static void main(String[] args) {
        System.out.println(new Solution0038().countAndSay(4));
    }
    public String countAndSay(int n) {
        List<String> nums = new ArrayList<>(n);
        nums.add("1");
        for (int i = 0; i < n-1; i++) {
            nums.add(getNextNumString(nums.get(i)));
        }
        return nums.get(nums.size()-1);
    }

    private String getNextNumString(String num){
        int length = num.length();
        // 1. 分割
        StringBuilder ans = new StringBuilder();
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (num.charAt(i) != num.charAt(i-1)){
                ans.append(String.valueOf(count)).append(num.charAt(i - 1));
                count = 1;
            }else
                count++;
        }
        ans.append(String.valueOf(count)).append(num.charAt(length - 1));
        return ans.toString();
    }
}
