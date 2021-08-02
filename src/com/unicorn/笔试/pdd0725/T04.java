package com.unicorn.笔试.pdd0725;

import java.util.Scanner;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-07-25 8:29 下午
 */
public class T04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = sc.nextInt();
        }
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (nums[i] != 0){
                if (s1.length() <= s2.length()){
                    s1.append(i);
                }else
                    s2.append(i);
                nums[i]--;
            }
        }
        System.out.println(Integer.parseInt(s1.toString()) * Integer.parseInt(s2.toString()));
    }
}
