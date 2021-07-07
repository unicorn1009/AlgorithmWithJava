package com.unicorn.niuke.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/04/28 10:24
 *
 * @author Unicorn
 */
public class 数组中和为0的三元组 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-10, 0, 10, 20, -10, -40}));
    }
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            // num[i] 是 a
            // 找 b + c = -a;
            if (i > 0 && num[i] == num[i-1]){
                continue;   // 去重
            }
            int x = -num[i];
            int left = i+1;
            int right = num.length-1;
            while (left < right){
                if (num[left] + num[right] == x){
                    // 去重
                    if (left > i+1 && num[left] == num[left-1] ){
                        left++;
                    }else if (right != num.length-1 && num[right] == num[right+1]){
                        right--;
                    }else{
                        ArrayList<Integer> list=new ArrayList<>();
                        list.add(num[i]);
                        list.add(num[left]);
                        list.add(num[right]);
                        ans.add(list);
                        left++;
                        right--;
                    }
                }else if (num[left] + num[right] < x){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return ans;
    }
}
