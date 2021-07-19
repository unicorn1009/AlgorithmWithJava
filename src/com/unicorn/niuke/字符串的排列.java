package com.unicorn.niuke;

import java.util.*;

/**
 * <p>
 *     输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *     输入描述：
 *      输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * </p>
 * Created on 2021/6/22.
 *
 * @author Unicorn
 */
public class 字符串的排列 {
    public static void main(String[] args) {
        字符串的排列 a = new 字符串的排列();
        ArrayList<String> list = a.Permutation("cbaa");
        System.out.println(list);
    }

    ArrayList<String> ans;
    Set<String> set;
    public ArrayList<String> Permutation(String str) {
        ans = new ArrayList<>();
        set = new HashSet<>();
        // 先对字符串按照字典序排序
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);

        boolean[] used = new boolean[charArray.length];
//        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(charArray[i]);
            used[i] = true;
            dfs(charArray, stringBuilder, used);
            used[i] = false;

        }

        return ans;
    }

    private void dfs(char[] charArray, StringBuilder stringBuilder, boolean[] used) {
        if (stringBuilder.length() == charArray.length){
            String s = stringBuilder.toString();
            if (!set.contains(s)){
                ans.add(s);
                set.add(s);
            }
            return;
        }

        for (int i = 0; i < charArray.length; i++) {
            if (!used[i]){
                stringBuilder.append(charArray[i]);
                used[i] = true;
                dfs(charArray, stringBuilder, used);
                used[i] = false;
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        }

    }
}
