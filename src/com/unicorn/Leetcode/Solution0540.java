package com.unicorn.Leetcode;

/**
 * <p>
 *     540. 有序数组中的单一元素
 * </p>
 * Created on 2021/03/22 20:02
 *
 * @author Unicorn
 */
public class Solution0540 {
    public static void main(String[] args) {
        int[] arr = {3,3,5,7,7,11,11};
        System.out.println(new Solution0540().singleNonDuplicate(arr));
    }
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int l = 0, r = nums.length-1;

        while (r > l){
            // 数组长度为奇数, mid肯定为最中间, 左右长度肯定为偶数
            int mid = (l+r)/2;
            if (((l-r)/2) % 2  == 0){
                if (nums[mid] == nums[mid-1]){
                    // 如果中间值与左边相等, 则单值在左边
                    r = mid;
                }else if (nums[mid] == nums[mid+1]){
                    // 如果中间值与右边相等, 则单值在右边
                    l = mid;
                }else {
                    return nums[mid];
                }
            }else {
                if (nums[mid] == nums[mid-1]){
                    // 如果中间值与左边相等, 则单值在右边
                    l = mid+1;
                }else if (nums[mid] == nums[mid+1]){
                    // 如果中间值与右边相等, 则单值在左边
                    r = mid-1;
                }else {
                    return nums[mid];
                }
            }
        }
        return nums[r];
    }
}
