package com.unicorn.Leetcode;

import java.math.BigInteger;

/**
 * <p>
 *     96. 不同的二叉搜索树
 * </p>
 * Created on 2021/03/24 09:17
 *
 * @author Unicorn
 */
public class Solution0096 {
    public static void main(String[] args) {
        Solution0096 solution0096 = new Solution0096();
        for (int i = 0; i < 19; i++) {
            System.out.println(solution0096.numTrees(i));
        }

    }
    public int numTrees(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

}
