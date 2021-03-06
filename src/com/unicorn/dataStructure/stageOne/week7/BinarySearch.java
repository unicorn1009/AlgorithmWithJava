package com.unicorn.dataStructure.stageOne.week7;

import com.unicorn.jzoffer.JZ040;

import java.util.Arrays;

/**
 * <p>
 * </p>
 * Created on 2021/2/25.
 *
 * @author Unicorn
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,1,2};
//        int res = new BinarySearch().search(arr, 2, 0, arr.length-1);
        int res = new BinarySearch().search(arr, 3);
        System.out.println(res);
    }


    // 递归方法
    public int search(int[] arr, int target, int l, int r){
        if (l > r) return -1;

        int mid = l + (r-l)/2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) return search(arr,target,l, mid-1);
        else return search(arr, target, mid+1, r);

    }

    // 非递归写法
    public int search(int[] arr, int target){
        int l = 0, r = arr.length-1;
        int mid = 0;
        while (l <= r){
            mid = l + (r - l) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target){
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return -1;
    }

}
