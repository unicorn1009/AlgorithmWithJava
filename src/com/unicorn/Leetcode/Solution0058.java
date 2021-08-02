package com.unicorn.Leetcode;

/**
 * <p>
 *     58. 最后一个单词的长度
 * </p>
 *
 * @author unicorn
 * @create 2021-03-30 12:19 上午
 */
public class Solution0058 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("ss sss "));
    }
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int count = 0;
        for (int i = s.length()-1; i >=0; i--) {
            char c = s.charAt(i);
            if ((c - 'a' >= 0 && c - 'a' < 26) || (c - 'A' >= 0 &&  c - 'A' < 26)){
                // 是字母
                count++;
            }else {
                break;
            }
        }
        return count;
    }
}
