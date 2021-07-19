package com.unicorn.Leetcode;

/**
 * <p>
 *     67. 二进制求和
 *      给你两个二进制字符串，返回它们的和（用二进制表示）。
 *      输入为 非空 字符串且只包含数字 1 和 0。
 * </p>
 *
 * @author unicorn
 * @create 2021-03-31 11:06 下午
 */
public class Solution0067 {
    public static void main(String[] args) {
        System.out.println(addBinary("1011","11"));
    }
    public static String addBinary(String a, String b) {
        boolean needCarry = false;
        char[] achar = a.toCharArray();
        char[] bchar = b.toCharArray();
        int i = a.length();
        int j = b.length();
        int x = Math.max(i, j)+1;
        char[] ans = new char[x];
        i--;j--;x--;
        while (i >= 0 || j >= 0){
            if (i < 0){
                if (needCarry && bchar[j] == '1'){
                    ans[x--] = '0';
                }else if (needCarry && bchar[j] == '0'){
                    ans[x--] = '1';
                    needCarry = false;
                }else {
                    ans[x--] = bchar[j];
                    needCarry = false;
                }
                j--;
                continue;
            }
            if (j < 0){
                if (needCarry && achar[i] == '1'){
                    ans[x--] = '0';
                }else if (needCarry && achar[i] == '0'){
                    ans[x--] = '1';
                    needCarry = false;
                }else {
                    ans[x--] = achar[i];
                    needCarry = false;
                }
                i--;
                continue;
            }
            if (achar[i] == '0' && bchar[j] == '0' && !needCarry){
                ans[x--] = '0';
                needCarry = false;

            }else if ((achar[i] == '0' && bchar[j] == '0' && needCarry) || (achar[i] == '1' && bchar[j] == '0' && !needCarry) || (achar[i] == '0' && bchar[j] == '1' && !needCarry)){
                ans[x--] = '1';
                needCarry = false;

            }else if ((achar[i] == '0' && bchar[j] == '1' && needCarry) || (achar[i] == '1' && bchar[j] == '0' && needCarry) || (achar[i] == '1' && bchar[j] == '1' && !needCarry)){
                ans[x--] = '0';
                needCarry = true;
            }else {
                ans[x--] = '1';
                needCarry = true;
            }
            i--;
            j--;
        }
        if (needCarry){
            ans[x] = '1';
            return new String(ans);

        }else{
            ans[x] = '0';
            return new String(ans, 1, ans.length-1);
        }
    }
}
