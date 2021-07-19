package com.unicorn.mianshijindian.位运算;

/**
 * <p>
 *     面试题 05.07. 配对交换
 *     配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 * </p>
 * Created on 2021-7-8.
 *
 * @author Unicorn
 */
public class MS0507 {
    public static void main(String[] args) {
        int x = 102348;
        System.out.println(exchangeBits(x));
        System.out.println(exchangeBits1(x));
    }

    public static int exchangeBits(int num) {
        String s = Integer.toBinaryString(num);
        StringBuilder ans = new StringBuilder(s.length());
        if (s.length() % 2 == 1){
            s = "0"+s;
        }
        for (int i = 1; i < s.length(); i++) {
            if (i % 2 == 1 ){
                ans.append(s.charAt(i)).append(s.charAt(i-1));
            }
        }
        return Integer.parseInt(ans.toString(), 2);
    }

    // 别人家孩子的解法
    public static int exchangeBits1(int num) {
        int a = 0x55555555; // 奇数位全1
        System.out.println(Integer.toBinaryString(a));
        int b = 0xaaaaaaaa;// 偶数位全1
        System.out.println(Integer.toBinaryString(b));

        int c = num & a;    // 将num偶数位全变成0， 奇数位不变
        int d = num & b;    // 将num奇数位全变成0， 偶数位不变
        return c<<1 | d>>1;

    }
}
