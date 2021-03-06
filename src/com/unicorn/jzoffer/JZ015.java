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
        System.out.println(hammingWeight(-3));
        System.out.println(-3%2);
    }

    // TODO 剑指 Offer 15. 二进制中1的个数
    public static int hammingWeight(int n) {
        int ans = 0;
        while (Math.abs(n)>0){
            if (n%2 == 1 || n%2 == -1){
                ans++;
            }
            n /= 2;
        }
        return ans;
    }
}
