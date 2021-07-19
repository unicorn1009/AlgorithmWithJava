package com.unicorn.Leetcode;

import java.util.*;

/**
 * <p>
 * </p>
 * Created on 2021/6/19.
 *
 * @author Unicorn
 */
public class Solution1239 {
    public static void main(String[] args) {
        Solution1239 solution1239 = new Solution1239();
        int ret = solution1239.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz", "a"));
        System.out.println(ret);
    }

    public int maxLength(List<String> arr) {
        boolean[] canUse = new boolean[arr.size()];
        Arrays.fill(canUse, true);

        for (int i = 0; i < arr.size(); i++){
            canUse[i] = !isRepeat(arr.get(i));
        }

        for (int i = 0; i < arr.size(); i++) {
            if (canUse[i]){
                canUse[i] = false;
                dfs(arr.get(i), arr, canUse, i);
            }
        }
        return maxLength;
    }

    private int maxLength;

    private void dfs(String curStr, List<String> arr, boolean[] canUse, int index) {

        if (curStr.length()>maxLength){
            maxLength = curStr.length();
        }
        if (index >= arr.size()){
            return;
        }
        for (int i = index+1; i < arr.size(); i++) {
            if (canUse[i]){
                if (!isRepeat(curStr, arr.get(i))){
                    // 无重复字符
                    canUse[i] = false;
                    dfs(curStr+arr.get(i), arr, canUse, i);
                    canUse[i] = true;
                }
            }
        }
    }

    private boolean isRepeat(String str1, String str2){

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j))
                    return true;
            }
        }
        return false;
    }

    private boolean isRepeat(String str){

        Set<Character> set = new HashSet<>(26);
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))){
                return true;
            }else {
                set.add(str.charAt(i));
            }
        }
        return false;
    }

}
