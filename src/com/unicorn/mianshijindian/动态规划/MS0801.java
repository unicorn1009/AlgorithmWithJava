package com.unicorn.mianshijindian.动态规划;

/**
 * <p>
 *     面试题 08.01. 三步问题
 *     三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * </p>
 * Created on 2021-7-8.
 *
 * @author Unicorn
 */
public class MS0801 {

    public static void main(String[] args) {
        System.out.println(waysToStep(5));
    }

    public static int waysToStep(int n) {
        long[] ans = new long[]{1,2,4};
        if (n <= 3){
            return (int) ans[n-1];
        }

        for (int i = 4; i <= n; i++) {
            long x = ans[0]+ans[1]+ans[2];
            ans[0] =ans[1];
            ans[1] =ans[2];
            ans[2] = x % 1000000007;
        }
        return (int) ans[2];
    }

}
