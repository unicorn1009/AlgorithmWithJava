package com.unicorn.Leetcode;



/**
 * <p>
 *     20. 有效的括号
 *     给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * </p>
 * Created on 2021-01-30.
 *
 * @author Unicorn
 */
import com.unicorn.dataStructure.stageOne.week3.ArrayStack;
import java.util.HashMap;
import java.util.Stack;

public class Solution0020 {

    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid2(s));
    }

    public static boolean isValid(String s) {

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        ArrayStack<Character> stack = new ArrayStack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c=='[' || c=='{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }else {
                    Character popChar = stack.pop();
                    if (map.get(c) != popChar){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c=='[' || c=='{'){
                stack.push(c);
            }else {
                if (stack.isEmpty())
                    return false;

                Character popChar = stack.pop();
                if (map.get(c) != popChar)
                    return false;

            }
        }

        return stack.isEmpty();
    }
}
