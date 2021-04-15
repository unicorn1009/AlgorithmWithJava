package com.unicorn.Leetcode.group;

import java.util.Arrays;

/**
 * <p>
 * </p>
 * Created on 2021/04/10 14:59
 *
 * @author Unicorn
 */
public class G1 {
    public static void main(String[] args) {
        int[] bucket = {1,3,1,2,3,5,3}, vat = {6,8,7,8,9,10,11};
//        int[] bucket = {9,0,1}, vat = {0,2,2};
        System.out.println(storeWater(bucket, vat));
    }
    public static int storeWater(int[] bucket, int[] vat) {
        int ans = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (vat[i] == 0) continue;
            if (bucket[i] == 0) {
                bucket[i]++;
                ans++;
            }
            if (vat[i] != 2 && vat[i] % 2 == 0){
                // 最低要求是偶数，只需要升级到2
                while (bucket[i] < 2){
                    ans++;
                    bucket[i]++;
                }
            }else {
                // 最低要求是奇数，只需要升级到大于2的奇数
                while (bucket[i] % 2 == 0 || bucket[i] <= 2){
                    bucket[i]++;
                    ans++;
                }
            }
        }
        // 倒水
        boolean flag = false;
        while (true){
            // 倒一次
            flag = false;
            for (int i = 0; i < bucket.length; i++) {
                if (vat[i] > 0){
                    // 需要倒水
                    vat[i] -= bucket[i];
                    flag = true;
                }
            }
            if (flag)
                ans++;
            else
                break;
        }
        return ans;
    }
}
