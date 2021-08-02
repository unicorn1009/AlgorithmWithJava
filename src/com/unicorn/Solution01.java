package com.unicorn;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-07-31 11:50 上午
 */
public class Solution01 {
    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
    }

    public static int maxScore(String str){
        if (str.length() <= 1) return 0;
        int maxScore = 0;
        int count1 = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1'){
                count1++;
            }
        }
        if (count1 == str.length()) return str.length()-1;
        int count0 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0'){
                count0++;
            }else {
                count1--;
            }
            maxScore = Math.max(count0+count1, maxScore);
        }
        return maxScore;
    }
}
