package com.unicorn.jzoffer;

/**
 * <p>
 *     剑指 Offer 15. 二进制中1的个数
 * </p>
 * Created on 2021/3/4.
 *
 * @author Unicorn
 */
public class JZ015 {
    public static void main(String[] args) {
//        11111111111111111111111111111101
        System.out.println(hammingWeight(-3));
    }

    // TODO 剑指 Offer 15. 二进制中1的个数
    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1)  == 1){
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
}
