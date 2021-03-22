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
    public static void main(String[] args) {
        System.out.println(new Solution0055().canJump1(new int[]{1,0}));
    }


    // 贪心法 : 每次选择可以跳的最远的位置
    public boolean canJump1(int[] nums) {
        int site = 0;   // 当前所在位置
        while (true){
            // 选择下一个所在位置
            int maxStep = nums[site];
            int maxDistance = 0;
            int neeSite = site;
            for (int i = 1; i <= maxStep && site+i < nums.length; i++) {
                if (site+i+nums[site+i] >= nums.length-1) return true;
                if ((site+i+nums[site+i]) > maxDistance){
                    maxDistance = site+i+nums[site+i];
                    neeSite = site+i;
                }
            }
            site = neeSite;
            if (site >= nums.length-1) return true;
            if (maxDistance == 0) return false;
        }
    }


    // 暴力法
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
