package com.unicorn.niuke.排序;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>
 * </p>
 * Created on 2021/04/20 14:58
 *
 * @author Unicorn
 */
public class 最大数 {
    public static void main(String[] args) {
        String ans = solve(new int[]{10, 2});
        System.out.println(ans);
    }
    public static String solve (int[] nums) {
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if (numsStr[0].equals("0")){
            return "0";
        }
        StringBuilder ans= new StringBuilder();
        for (String s : numsStr) {
            ans.append(s);
        }
        return ans.toString();
    }
}
