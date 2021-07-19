package com.unicorn.mianshijindian.位运算;

/**
 * <p>
 *     面试题 05.06. 整数转换
 * </p>
 * Created on 2021-7-8.
 *
 * @author Unicorn
 */
public class MS0506 {
    public static void main(String[] args) {

        System.out.println(convertInteger(1, 2));
    }

    public static int convertInteger(int A, int B) {
        System.out.println(Integer.toBinaryString(A));
        System.out.println(Integer.toBinaryString(B));
        int ret = A ^ B;
        String s = Integer.toBinaryString(ret);
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                c++;
        }
        return c;
    }
}
