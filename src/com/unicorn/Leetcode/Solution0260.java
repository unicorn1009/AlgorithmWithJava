package com.unicorn.Leetcode;

/**
 * <p>
 *     260. 只出现一次的数字 III
 *     给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * </p>
 * Created on 2021-8-10.
 *
 * @author Unicorn
 */
public class Solution0260 {
    public static void main(String[] args) {
        singleNumber(new int[]{1,0});
    }
    public static int[] singleNumber(int[] nums) {
        // 1. 先对数组所有数进行异或操作, 最终结果就是两个单独的数做异或的结果
        int temp = 0;
        for (int num : nums) {
            temp = temp ^ num;
        }
        // 从右到左对异或结果temp找第一个不为0的位置
        int x = 0;
        for (int i = 0; i < 32; i++) {
            if ((temp>>i & 1) == 1){
                x = i;
                break;
            }
        }
        // 下面的x代表只有第x位不为0,其余位都是0的二进制数
        x = 1<<x;
        // 将整个数组里的数分为第x位是0和第x位是1的两部分, 分别异或, 最终答案即为异或结果
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & x) == 0){
                num1 = num1 ^ num;
            }else {
                num2 = num2 ^ num;
            }
        }
        return new int[]{num1, num2};
    }
}
