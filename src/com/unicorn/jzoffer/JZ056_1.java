package com.unicorn.jzoffer;

/**
 * <p>
 *     剑指 Offer 56 - I. 数组中数字出现的次数
 *     一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * </p>
 * Created on 2021/3/16 0016
 *
 * @author Unicorn
 */
public class JZ056_1 {
    public static void main(String[] args) {
        singleNumbers(new int[]{1,2,10,4,1,4,3,3,2,6});
    }

    // 分组异或 from LeetCode
    public static int[] singleNumbers(int[] nums) {
        int[] ans = new int[2];
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp ^= nums[i];
        }
        int a = temp;
        int count = 0;
        while (true){
            if ((a&1) == 1){
                break;
            }
            a>>=1;
            count++;
        }

        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i]>>>count & 1) == 1){
                ans1 ^= nums[i];
            }else {
                ans2 ^= nums[i];
            }
        }
        ans[0] = ans1;
        ans[1] = ans2;

        return ans;
    }
}
