package com.unicorn.jzoffer;

import java.util.Arrays;

/**
 * <p>
 *     调整数组顺序使奇数位于偶数前面
 * </p>
 * Created on 2021/2/24.
 *
 * @author Unicorn
 */
public class JZ021 {
    public static void main(String[] args) {
        int[] a = new int[]{0, 2, 3, 5, 5, 8, 8, 9,10};
        System.out.println(Arrays.toString(a));

        new JZ021().exchange1(a);
        System.out.println(Arrays.toString(a));
    }
    // 法一 : 首位双指针
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length-1;
        while (true){
            // 从左往右查找, 若为奇数则跳过
            while (i<=j && nums[i]%2 != 0){
                i++;
            }
            // 从右往左查找, 若为偶数则跳过
            while (i<=j && nums[j]%2 == 0){
                j--;
            }
            if (i>=j) break;
            swap(nums, i, j);
            i++;
            j--;
        }
        return nums;
    }

    // 法二 : 快慢双指针
    public int[] exchange1(int[] nums) {
        int fast = 0, low = 0;
        while (fast < nums.length){
            if (nums[fast] % 2 == 1){   //奇数
                int temp = nums[fast];
                nums[fast] = nums[low];
                nums[low] = temp;
                low++;
            }
            fast++;
        }
        return nums;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
