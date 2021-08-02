package com.unicorn.大厂热题;

/**
 * <p>
 * </p>
 * Created on 2021-7-30.
 *
 * @author Unicorn
 */
public class 第一个只出现一次的字符 {
    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("google"));
    }
    public static int FirstNotRepeatingChar(String str) {
        // 128长度数组存储字符出现的次数
        int[] cnts = new int[128];
        // 计算每个字符出现的次数
        for (int i = 0; i < str.length(); i++)
            cnts[str.charAt(i)]++;
        // 从头到尾再遍历一遍字符串, 看哪个字符的出现次数等于1
        for (int i = 0; i < str.length(); i++)
            if (cnts[str.charAt(i)] == 1)
                return i;
        return -1;
    }
}
