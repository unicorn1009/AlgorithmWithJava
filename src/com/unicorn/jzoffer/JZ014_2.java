package com.unicorn.jzoffer;

import com.unicorn.common.Array;
import com.unicorn.util.ArrayUtil;

import java.math.BigInteger;
import java.util.Map;

/**
 * <p>
 * </p>
 * Created on 2021/07/26 08:59
 *
 * @author Unicorn
 */
public class JZ014_2 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(60));
    }

    // 至少要分两段
    public static int cuttingRope(int n) {
        BigInteger[] rope = new BigInteger[n+1];
        rope[2] = BigInteger.valueOf(2);
        rope[3] = BigInteger.valueOf(3);
        for (int i = 4; i <= n; i++) {
            BigInteger curMax = BigInteger.valueOf(0);
            for (long j = 2L; j < i-1; j++) {
                // j 是最后一段的长度
                curMax = rope[(int) (i - j)].multiply(BigInteger.valueOf(j)).mod(BigInteger.valueOf(1000000007)).max(curMax);
                // curMax = Math.max(curMax.intValue(), rope[(int) (i-j)].multiply(BigInteger.valueOf(i)).intValue());
            }
            rope[i] = curMax;
        }
         ArrayUtil.printArray1D(rope);
        return rope[n].intValue();
    }

    // 56 - 774840978
    // 57 - 162261460
    // 60 - 486784380

}
