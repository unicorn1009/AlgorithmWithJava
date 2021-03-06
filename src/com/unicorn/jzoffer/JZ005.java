package com.unicorn.jzoffer;

/**
 * <p>
 *     替换空格
 * </p>
 * Created on 2021/2/23.
 *
 * @author Unicorn
 */
public class JZ005 {
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    public String replaceSpace1(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                res.append("%20");
            else
                res.append(c);
        }
        return res.toString();
    }
}
