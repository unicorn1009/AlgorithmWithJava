package com.unicorn.mianshijindian.字符串;

/**
 * <p>
 * </p>
 * Created on 2021/6/17.
 *
 * @author Unicorn
 */
public class MS0103 {
    public static void main(String[] args) {
        System.out.println(replaceSpaces("               ", 5));
    }
    // 要求使用字符数组
    public static String replaceSpaces(String S, int length) {
        char[] charArray = S.toCharArray();
        int offset = charArray.length-1;
        int count = 0;
        for (int i = length-1; i >= 0; i--) {
            if (charArray[i] != ' '){
                charArray[offset--] = charArray[i];
                count++;
            }else {
                // 遇到空格
                charArray[offset--] = '0';
                charArray[offset--] = '2';
                charArray[offset--] = '%';
                count+=3;
            }
        }
        return new String(charArray, offset+1, count);
    }
}
