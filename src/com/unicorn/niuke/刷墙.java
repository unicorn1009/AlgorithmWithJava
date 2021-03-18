package com.unicorn.niuke;

import java.util.Scanner;

/**
 * <p>
 * </p>
 * Created on 2021/03/18 20:46
 *
 * @author Unicorn
 */
public class 刷墙 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String ss = in.next();

        System.out.println(game(n, ss));
    }
    public static int game(int n, String ssss){
        int length = ssss.length();
        int min = length;

        for (int i = 0; i <= length; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                if (ssss.charAt(j) == '0')
                    left++;
            }
            for (int j = i; j < length; j++) {
                if (ssss.charAt(j) == '1')
                    right++;
            }
            if (left+right < min)
                min = left+right;
        }
        return min;

    }
}
