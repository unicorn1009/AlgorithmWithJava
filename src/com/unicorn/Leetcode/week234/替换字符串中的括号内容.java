package com.unicorn.Leetcode.week234;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-03-28 10:54 上午
 */
public class 替换字符串中的括号内容 {
    public static void main(String[] args) {
        替换字符串中的括号内容 obj = new 替换字符串中的括号内容();
        String s = "(name)is(age)yearsold";
        List<List<String>> know = new ArrayList<>();
        List<String> c1 = new ArrayList<>();
        c1.add("name");
        c1.add("bob");
        List<String> c2 = new ArrayList<>();
        c2.add("age");
        c2.add("two");
        know.add(c1);
        know.add(c2);
        System.out.println(obj.evaluate(s, know));


    }
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder ans = new StringBuilder();
        int preIndex = -1;
        int tailIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '(' && c != ')' && tailIndex >= preIndex){
                ans.append(c);
            }else if (c == '('){
                preIndex = i;
            }else if (c == ')'){
                // 组成一个键;
                String value = getValue(knowledge, s.substring(preIndex + 1, i));
                if (value != null){
                    ans.append(value);
                }else {
                    ans.append('?');
                }
                tailIndex = i;
            }
        }

        return ans.toString();
    }
    private String getValue(List<List<String>> knowledge, String k){
        for (List<String> kv : knowledge) {
            if (kv.get(0).equals(k)){
                return kv.get(1);
            }
        }
        return null;
    }
}
