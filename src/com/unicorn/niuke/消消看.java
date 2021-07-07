package com.unicorn.niuke;

import java.util.*;

/**
 * <p>
 * </p>
 * Created on 2021/04/15 19:45
 *
 * @author Unicorn
 */
public class 消消看 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        for (int i = 0; i < n; i++) {
//            Scanner in1 = new Scanner(System.in);
//            handler(in1.next());
//
//        }
//
        int[] index = findIndex("010010111101000");
        System.out.println(Arrays.toString(index));

//        handler("010010111101000", new int[2], true);
    }

    private static void handler(String input, int[] score, Boolean isMe) {
        if (input.isEmpty() || isAllZero(input)) {
            System.out.println(score[0]-score[1]);
            return;
        }
        int[] index = findIndex(input);
        if (isMe) {
            score[0]+=index[1]-index[0]+1;
        } else {
            score[1]+=index[1]-index[0]+1;
        }
        System.out.println(Arrays.toString(index));
        handler(input.substring(0, index[0]) + input.substring(index[1]), score, !isMe);

    }

    // 找出01串str中连续'1'最长的子串前后下标[start, end]
    private static int[] findIndex(String str) {
        int start = -1, end = -1;
        int maxStart = 0, maxEnd = 0;
        int maxLen = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                if (start == -1) {
                    start = i;
                }
                end = i;
            } else {
                //   str.charAt(i) == '0'
                if (end - start > maxLen) {
                    maxLen = end - start;
                    maxStart = start;
                    maxEnd = end;
                }
                start = -1;
            }
        }
        if (end - start > maxLen) {
            maxStart = start;
            maxEnd = end;
        }
        return new int[]{maxStart, maxEnd};

    }

    private static boolean isAllZero(String str){
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1'){
                return false;
            }
        }
        return true;
    }
}
