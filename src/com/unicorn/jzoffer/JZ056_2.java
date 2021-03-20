package com.unicorn.jzoffer;

/**
 * <p>
 * </p>
 * Created on 2021/03/19 09:01
 *
 * @author Unicorn
 */
public class JZ056_2 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{9, 7, 9, 7, 9, 7, 1}));
    }


    // TODO 位运算 + 求余

    // 暴力法
    public static int singleNumber(int[] nums) {
        int ans = 0;

        bgm:for (int i = 0; i < nums.length; i++) {
            if (i == nums.length-1) return nums[nums.length-1];
            for (int j = 0; j < nums.length; j++) {
                if (j != i && (nums[i] ^ nums[j]) == 0){
                    break;
                }
                if (j == nums.length-1){
                    ans = nums[i];
                    break bgm;
                }
            }
        }
        return ans;
    }
}
