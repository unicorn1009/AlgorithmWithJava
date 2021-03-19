package com.unicorn.jzoffer;

/**
 * <p>
 *     剑指 Offer 61. 扑克牌中的顺子
 * </p>
 * Created on 2021/03/18 15:16
 *
 * @author Unicorn
 */
public class JZ061 {
    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{0, 0, 0, 0, 0}));
    }
    public static boolean isStraight(int[] nums) {

        int zero = 0;
        int min = 13;
        int max = 0;
        for (int i = 0; i < 5; i++) {
            if (nums[i] == 0)
                zero++;
            else
                min  = Math.min(min, nums[i]);
            max  = Math.max(max, nums[i]);
        }
        if (max == 0) return true;
        if (max - min >= 5){
            return false;
        }
        boolean[] isTrue = new boolean[5];
        for (int i = 0; i < 5; i++) {
            if (nums[i] != 0){
                isTrue[nums[i] - min] = true;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (!isTrue[i]){
                zero--;
            }
        }
        return zero >= 0;

    }
}
