package com.unicorn.mianshijindian.字符串;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     面试题 01.04. 回文排列
 * </p>
 * Created on 2021/6/17.
 *
 * @author Unicorn
 */
public class MS0104 {
    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("tactcoao"));
    }

    // 给定字符串中的字符是否能排列成回文串
    public static boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }else {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
        }
        Collection<Integer> values = map.values();

        // 分奇偶
        if (s.length() % 2 == 0){
            // 偶数, 字符需成双
            for (Integer value : values) {
                if (value % 2 != 0)
                    return false;
            }
            return true;
        }else {
            // 奇数, 只允许一个字符落单
            int c = 0;
            for (Integer value : values) {
                if (value % 2 != 0){
                    c++;
                }
            }
            if (c!=1)
                return false;
            return true;
        }
    }
}
