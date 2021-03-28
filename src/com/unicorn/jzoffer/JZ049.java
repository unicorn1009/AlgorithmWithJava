package com.unicorn.jzoffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * </p>
 *
 * @author unicorn
 * @create 2021-03-20 11:58 下午
 */
public class JZ049 {
    public static void main(String[] args) {
        System.out.println(new JZ049().nthUglyNumber1(10));
    }

    // 法二 : Set打表
    public int nthUglyNumber1(int n) {
        // 使用一个数组记录每个数是否是丑数
        Set<Integer> uglyNums = new HashSet<>();
        uglyNums.add(1);   // 1
        uglyNums.add(2);   // 2
        uglyNums.add(3);   // 3
        uglyNums.add(4);   // 4
        uglyNums.add(5);   // 5
        int count = 5;  // 已知的丑数个数
        int curNum = 6;
        while (count < n) {
            if (isUgly1(uglyNums, curNum)){
                uglyNums.add(curNum);
                count++;
            }
            curNum++;
        }
        return curNum-1;
    }

    private boolean isUgly1(Set<Integer> uglyNums, int num) {
        if (num % 2 != 0 && num % 3 != 0 && num % 5 != 0) {
            return false;
        } else {
            // 能被2,3,5整除
            if (num % 2 == 0) {
                num /= 2;
                // 数字变小了, 可以去数组中查找了
                if (uglyNums.contains(num)) {
                    return true;
                } else {
                    return false;
                }
            } else if (num % 3 == 0) {
                num /= 3;
                // 数字变小了, 可以去数组中查找了
                if (uglyNums.contains(num)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                num /= 5;
                // 数字变小了, 可以去数组中查找了
                if (uglyNums.contains(num)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }


    // 法一 : List打表 超时
    public int nthUglyNumber(int n) {
        // 使用一个数组记录每个数是否是丑数
        List<Boolean> uglyNums = new ArrayList<>(n);
        uglyNums.add(false);   // 0
        uglyNums.add(true);   // 1
        uglyNums.add(true);   // 2
        uglyNums.add(true);   // 3
        uglyNums.add(true);   // 4
        uglyNums.add(true);   // 5
        int count = 5;  // 已知的丑数个数
        int curNum = 6;
        while (count < n) {
            if (isUgly(uglyNums, curNum)){
                uglyNums.add(true);
                count++;
            }else {
                uglyNums.add(false);
            }
            curNum++;
        }
        return curNum-1;
    }

    private boolean isUgly(List<Boolean> uglyNums, int num) {
        if (num % 2 != 0 && num % 3 != 0 && num % 5 != 0) {
            return false;
        } else {
            // 能被2,3,5整除
            if (num % 2 == 0) {
                num /= 2;
                // 数字变小了, 可以去数组中查找了
                if (uglyNums.get(num)) {
                    return true;
                } else {
                    return false;
                }
            } else if (num % 3 == 0) {
                num /= 3;
                // 数字变小了, 可以去数组中查找了
                if (uglyNums.get(num)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                num /= 5;
                // 数字变小了, 可以去数组中查找了
                if (uglyNums.get(num)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

}
