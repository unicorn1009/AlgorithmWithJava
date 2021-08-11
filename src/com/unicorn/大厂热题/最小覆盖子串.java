package com.unicorn.大厂热题;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     76. 最小覆盖子串
 * </p>
 * Created on 2021-8-3.
 *
 * @author Unicorn
 */
public class 最小覆盖子串 {
    public static void main(String[] args) {
        最小覆盖子串 aaa = new 最小覆盖子串();
        System.out.println(aaa.minWindow("aac", "aab"));
    }


    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()){
            return "";
        }
        int[] need = new int[128];
        //记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int left = 0, right = 0, windowSize = s.length()+1, needCharCount = t.length(), start = 0;
        //遍历所有字符
        while (right < s.length()) {
            char c = s.charAt(right);
            if (need[c] > 0) {  //需要字符c
                needCharCount--;
            }
            // 进入窗口的所有字符都加入need数组，如果need[index]<0 , 说明是不需要的冗余字符
            need[c]--;//把右边的字符加入窗口
            if (needCharCount == 0) {//窗口中已经包含所有字符
                while (left < right && need[s.charAt(left)] < 0) {
                    // 只要遇到冗余字符，则将该字符从窗口中移除，并且left++
                    need[s.charAt(left)]++;//释放右边移动出窗口的字符
                    left++;//指针右移
                }
                // 出了while循环表示窗口无法再缩小了，此时更新答案
                if (right - left + 1 < windowSize) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    windowSize = right - left + 1;
                    start = left;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //更新完答案后，将left继续向左移动一位，使得窗口不满足要求，需要继续right右移寻找新的答案
                need[s.charAt(left)]++;
                left++;
                needCharCount++;
            }
            right++;
        }
        return windowSize == s.length()+1 ? "" : s.substring(start, start + windowSize);
    }


}
