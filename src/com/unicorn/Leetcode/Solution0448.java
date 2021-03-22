package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *     448. 找到所有数组中消失的数字
 * </p>
 * Created on 2021/3/1.
 *
 * @author Unicorn
 */
public class Solution0448 {
    public static void main(String[] args) {
        int[] arr = { 2,2};
        List<Integer> numbers = new Solution0448().findDisappearedNumbers1(arr);
        System.out.println(numbers);
    }

    // 法二 : 原地操作 : from leetcode官方
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int arrLen = nums.length;

        for (int i = 0; i < arrLen; i++) {
            nums[(nums[i]-1)%arrLen] += arrLen;
        }
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= arrLen){
                list.add(i+1);
            }
        }

        return list;
    }

    // 法一, 使用额外数组空间
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]-1] = 1;
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                list.add(i+1);
            }
        }

        return list;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
