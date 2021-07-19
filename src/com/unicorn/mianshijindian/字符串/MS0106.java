package com.unicorn.mianshijindian.字符串;

/**
 * <p>
 *
 *     面试题 01.06. 字符串压缩
 *     字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * </p>
 * Created on 2021/6/18.
 *
 * @author Unicorn
 */
public class MS0106 {
    public static void main(String[] args) {
        System.out.println(compressString("abcddddd"));
    }

    public static String compressString(String S) {
        if (S.length() <= 2)
            return S;
        StringBuilder sb = new StringBuilder();
        // 只要遇到与前一个字符不相同的字符, 则重新开始计数
        char pre = S.charAt(0);
        int c = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != pre){
                sb.append(pre);
                sb.append(c);
                c = 1;
            }else {
                // 与上一字符相同
                c++;
            }
            pre = S.charAt(i);
        }
        sb.append(pre);
        sb.append(c);
        return sb.length() >= S.length() ? S : sb.toString();
    }
}
