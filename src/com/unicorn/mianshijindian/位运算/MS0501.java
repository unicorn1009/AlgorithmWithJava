package com.unicorn.mianshijindian.位运算;

/**
 * <p>
 *     面试题 05.01. 插入
 *     给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。
 *
 * 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。
 *
 * </p>
 * Created on 2021-7-8.
 *
 * @author Unicorn
 */
public class MS0501 {
    public static void main(String[] args) {
        MS0501 ms0501 = new MS0501();
        System.out.println(ms0501.insertBits(1024, 19, 2, 9));
        int allOnes = ~0;
        System.out.println(Integer.toBinaryString(allOnes));

    }
    public int insertBits(int N, int M, int i, int j) {
        String nStr = Integer.toBinaryString(N);
        String mStr = Integer.toBinaryString(M);
        mStr = addZeroForNum(mStr, j - i + 1);
        int startIndex = nStr.length() - (j + 1);
        int endIndex = nStr.length() - (i + 1);
        String ans = nStr.substring(0, Math.max(startIndex, 0))+mStr+nStr.substring(endIndex+1);
        return Integer.parseInt(ans, 2);
    }

    public String addZeroForNum(String str, int strLength) {
        int strLen = str.length();
        StringBuilder sb = null;
        while (strLen < strLength) {
            sb = new StringBuilder();
            sb.append("0").append(str);// 左补0
            // sb.append(str).append("0");//右补0
            str = sb.toString();
            strLen = str.length();
        }
        return str;
    }

    // 别人家孩子写的解法
    public int insertBits1(int N, int M, int i, int j) {
        // 先把相应的位置零
        int allOnes = ~0;
        int left = j == 31 ? 0 : (allOnes << (j + 1));
        int right = (1 << i) - 1;
        int mask = (left | right);
        N &= mask;
        M <<= i;
        return N | M;
    }


}
