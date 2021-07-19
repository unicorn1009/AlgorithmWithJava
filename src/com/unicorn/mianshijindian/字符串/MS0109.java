package com.unicorn.mianshijindian.字符串;

/**
 * <p>
 * </p>
 * Created on 2021/6/18.
 *
 * @author Unicorn
 */
public class MS0109 {
    public static void main(String[] args) {
        System.out.println(isFlipedString("ab", "ba"));
    }

    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        if (s1.equals(s2)){
            return true;
        }

        String S = s2+s2;
        return S.contains(s1);
    }
}
