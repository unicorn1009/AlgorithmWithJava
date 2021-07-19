package com.unicorn.jzoffer;

import java.util.*;

/**
 * <p>
 *     剑指 Offer 38. 字符串的排列
 *     输入一个字符串，打印出该字符串中字符的所有排列。
 * </p>
 * Created on 2021/03/19 09:23
 *
 * @author Unicorn
 */
public class JZ038 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new JZ038().permutation("aac")));
    }

    public String[] permutation(String s) {
        int len = s.length();
        Set<String> ans = new HashSet<>();
        int depth = 0;
        StringBuilder path = new StringBuilder(len);
        boolean[] used = new boolean[len];
        dfs(s, depth, path, len, ans, used);
        return ans.toArray(new String[ans.size()]);
    }

    private void dfs(String s, int depth, StringBuilder path, int len, Set<String> ans, boolean[] used) {
        if (depth == len){
            ans.add(path.toString());
            return;
        }

        for (int i = 0; i < len; i++) {
           if (!used[i]){
               used[i] = true;
               path.append(s.charAt(i));
               dfs(s,depth+1, path, len, ans, used);
               path.deleteCharAt(path.length()-1);
               used[i] = false;
           }
        }
    }


}
