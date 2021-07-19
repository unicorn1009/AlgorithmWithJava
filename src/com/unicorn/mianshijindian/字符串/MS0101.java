package com.unicorn.mianshijindian.字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * </p>
 * Created on 2021/6/17.
 *
 * @author Unicorn
 */
public class MS0101 {
    public static void main(String[] args) {
        System.out.println('e'^'a'^'e'^1);
    }

    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            if (set.contains(astr.charAt(i)))
                return false;
            set.add(astr.charAt(i));
        }
        return true;
    }
}
