package com.unicorn.jzoffer;

/**
 * <p>
 *     剑指 Offer 16. 数值的整数次方
 * </p>
 * Created on 2021/03/26 13:18
 *
 * @author Unicorn
 */
public class JZ016 {
    public static void main(String[] args) {
        double a = -2;
        int b = -2147483648;
        System.out.println(myPow1(a, b));
        System.out.println(Math.pow(a,b));

    }

    public static double myPow1(double x, int n) {
        if (n == 0) return 1;
        boolean flag = false;
        if (n == -2147483648){
            flag = true;
            n += 1;
        }
        if (n < 0){
            x = 1/x;
            n = -n;
        }
        if (n == 1) return x;

        if (n % 2 == 0){
            // n是偶数
            x = Math.abs(x);
        }

        if (n % 2 == 0){
            // n 偶
            double v = myPow1(x, n / 2);
            if (flag)
                return  v*v*x;
            else return v*v;
        }else {
            double v = myPow1(x, n / 2);
            if (flag)
                return v*v*x*x;
            else return v*v*x;
        }
    }

    // n过大时, 数组长度超内存
    public static double myPow(double x, int n) {
        // n大于0还是小于0
        // n是奇数还是偶数
        if (n == 0) return 1;
        if (n < 0){
            x = 1/x;
            n = -n;
        }
        if (n == 1) return x;
        double[] ans = new double[n/2+2];
        if (n % 2 == 0){
            // n是偶数
            x = Math.abs(x);
        }
        ans[1] = x;
        for (int i = 2; i <= n / 2 + 1; i++) {
            if (i % 2 == 0){
                // i 是偶数
                ans[i] = ans[i/2]*ans[i/2];
            }else {
                // i 是奇数
                ans[i] = ans[i/2]*ans[i/2+1];
            }
        }
        if (n % 2 == 0){
            // n是偶数
            return ans[n/2] * ans[n/2];
        }else {
            return ans[n/2] * ans[n/2 +1];
        }

    }
}
