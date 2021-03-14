package com.unicorn.Leetcode;

public class Solution5701 {
    public static void main(String[] args) {
        String s1 = "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkyoooooooooooooooooooooooooooooooooooooooooooooooo";
        String s2 = "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkfoooooooooooooooooooooooooooooooooooooooooooooooo";
        System.out.println(areAlmostEqual(s1, s2));
    }
    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() == 1) return s1.charAt(0) == s2.charAt(0);
        int length = s1.length();
        char char1 = s1.charAt(0), char2 = s2.charAt(0), char3 = s1.charAt(0), char4 = s2.charAt(0);
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                if (count > 2) return false;
                if (count == 0){
                    char1 = s1.charAt(i);
                    char2 = s2.charAt(i);
                }else {
                    char3 = s1.charAt(i);
                    char4 = s2.charAt(i);
                    if (char3 !=  char2 || char1 != char4)
                        return false;
                }
                count += 1;
            }
        }
        if (count == 2 || count == 0)
            return true;
        return false;
    }
}
