package com.unicorn.Leetcode;

/**
 * <p>
 *     1816. 截断句子
 * </p>
 * Created on 2021/04/04 21:28
 *
 * @author Unicorn
 */
public class Solution1816 {
    public String truncateSentence(String s, int k) {
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                k--;
                index = i;
            }
            if (k == 0){
                break;
            }
        }
        if (k == 0){
            return s.substring(0,index);
        }
        return s;
    }
}
