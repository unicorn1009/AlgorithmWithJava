package com.unicorn.笔试.华为0421;

import com.unicorn.util.ArrayUtil;

/**
 * <p>
 * </p>
 * Created on 2021/04/21 19:16
 *
 * @author Unicorn
 */
public class 棋牌室 {
    public static void main(String[] args) {
        int[][] arr = {{0,1,10}, {1,2,20}};
        client(arr, 30);
    }

    public static void client(int[][] calls, int tables){
        int[] ans = new int[24];
        for1: for (int[] call : calls) {
            int in = call[0];
            int out = call[1];
            int nums = call[2];
            for (int i = in; i < out; i++) {
                ans[i] += nums;
                if (ans[i] > tables){
                    for(int j = i ; j >= in; j--){
                        ans[i] -= nums;
                    }
                    continue for1;
                }
            }
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
            if (i != ans.length-1)
                System.out.print(" ");
        }
    }
}
