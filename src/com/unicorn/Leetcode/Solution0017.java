package com.unicorn.Leetcode;

import java.util.*;

/**
 * <p>
 *     17. 电话号码的字母组合
 *     给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * </p>
 * Created on 2021/3/10.
 *
 * @author Unicorn
 */
public class Solution0017 {
    public static void main(String[] args) {

        List<String> stringList = new Solution0017().letterCombinations("");
        for (String s : stringList) {
            System.out.println(s);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        int len = digits.length();

        dfs(ans, len, 0, map, new char[len], digits);
        return ans;
    }

    private void dfs(List<String> ans, int len, int depth, Map<Character, List<Character>> map, char[] charArray, String digits) {
        if (depth == len){
            ans.add(new String(charArray));
            return;
        }

        List<Character> characterList = map.get(digits.charAt(depth));
        for (Character character :characterList){
            charArray[depth] = character;
            dfs(ans, len, depth+1, map, charArray, digits);
            // 本来需要在此对charArray进行回溯操作
        }
    }

}
