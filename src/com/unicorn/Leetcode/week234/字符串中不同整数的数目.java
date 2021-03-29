package com.unicorn.Leetcode.week234;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-03-28 10:32 上午
 */
public class 字符串中不同整数的数目 {
    public static void main(String[] args) {
        String word = "a1b01c001";
        System.out.println(numDifferentIntegers(word));


    }
    public static int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        StringBuilder num = new StringBuilder();
        String replaceStr = word.replaceAll("[a-z]", " ").trim();
        String[] strings = replaceStr.split("\\s+");
        for (String string : strings) {
            String trim = string.trim();
            if (trim.length() > 0){
                // 去除前导0
                int index = 0;
                for (int i = 0; i < trim.length(); i++) {
                    if (trim.charAt(i) == '0') {
                        index++;
                    }else {
                        break;
                    }
                }
                set.add(trim.substring(index));
            }
        }

        return set.size();

//        for (int i = 0; i < word.length(); i++) {
//            if (word.charAt(i) - 'a' >= 0 && word.charAt(i) - 'a' < 26){
//
//
//            }
//        }
//        return 0;
    }
}
