package com.unicorn.jzofferll;

/**
 * <p>
 *     剑指 Offer II 006. 排序数组中两个数字之和
 * </p>
 * Created on 2021-8-11.
 *
 * @author Unicorn
 */
public class JZ006 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2 = numbers.length-1;
        while (true){
            int curSum = numbers[index1] + numbers[index2];
            if (curSum == target){
                return new int[]{index1 , index2};
            }else if (curSum < target){
                index1++;
            }else {
                index2--;
            }
        }
    }
}
