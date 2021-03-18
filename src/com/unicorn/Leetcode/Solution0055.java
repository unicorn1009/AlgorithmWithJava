package com.unicorn.Leetcode;

/**
 * <p>
 *     55. 跳跃游戏
 * </p>
 * Created on 2021/03/18 15:04
 *
 * @author Unicorn
 */
public class Solution0055 {

    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] isOk = new boolean[len];
        isOk[0] = true;
        for (int i = 0; i < len; i++) {
            if (isOk[i]){
                int step = nums[i];
                for (int j = 1; j <= step && i+j < len; j++) {
                    isOk[i+j] = true;
                }
            }
        }
        return isOk[len-1];
    }

}
