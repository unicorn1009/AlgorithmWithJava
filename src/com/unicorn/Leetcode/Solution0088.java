package com.unicorn.Leetcode;

import com.unicorn.util.ArrayUtil;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-04-05 10:39 上午
 */
public class Solution0088 {
    public static void main(String[] args) {
        int[] a = new int[]{1};
        int[] b = new int[]{};
        merge(a, 1, b, 0);
        ArrayUtil.printArray1D(a);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            index--;
            if (nums1[i] >= nums2[j]) {
                nums1[index] = nums1[i];
                i--;
            } else {
                nums1[index] = nums2[j];
                j--;
            }
        }
        if (index > 0) {
            while (j >= 0) {
                index--;
                nums1[index] = nums2[j];
                j--;
            }
        }
    }
}
