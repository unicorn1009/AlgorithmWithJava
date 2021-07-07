package com.unicorn.niuke;

import java.util.*;

/**
 * <p>
 * </p>
 * Created on 2021/04/15 19:56
 *
 * @author Unicorn
 */
public class 赏金猎人 {
    public static void main(String[] args) {
//        getMoney(1, new int[]{1,8,3}, new int[]{1,8,5});

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums1 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }
        getMoney(k, nums1, nums2);



    }
    public static void getMoney(int k, int[] attack, int[] money){
        int[] ans = new int[attack.length];
        for (int i = 0; i < ans.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < attack.length; j++) {
                if (attack[j] < attack[i]){
                    list.add(money[j]);
                }
            }
            Collections.sort(list, Collections.reverseOrder());
            int bullet = k;
            ans[i] = money[i];
            for (Integer m : list) {
                ans[i] += m;
                k--;
                if (k == 0){
                    break;
                }
            }
        }
        for (int i = 0; i < ans.length; i++) {
            if (i != 0)
                System.out.print(" ");
            System.out.print(ans[i]);
        }
    }
}
