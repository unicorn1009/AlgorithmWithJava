package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     401. 二进制手表
 * </p>
 * Created on 2021/6/22.
 *
 * @author Unicorn
 */
public class Solution0401 {

    public static void main(String[] args) {
        Solution0401 solution0401 = new Solution0401();
        List<String> list = solution0401.readBinaryWatch1(1);
        System.out.println(list);
    }

    // 枚举时分
    public List<String> readBinaryWatch1(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn){
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }

    // 开始写的回溯法, 速度慢
    public List<String> readBinaryWatch(int turnedOn) {
        // 前四个表示小时, 8 4 2 1, 后6个表示分钟 32 16 8 4 2 1
        ans = new ArrayList<>();
        boolean[] isLight = new boolean[10];
        dfs(turnedOn, isLight, 1, 0);
        return ans;
    }

    private List<String> ans;

    /**
     *
     * @param turnedOn 总共有几个灯亮
     * @param isLight
     * @param index 当前是第几个亮灯, 从1开始
     * @param start 当前灯从第几个开始亮
     */
    private void dfs(int turnedOn, boolean[] isLight, int index, int start) {

        if (index == turnedOn+1){
            String time = isAns(isLight);
            if (!time.isEmpty()){
                ans.add(time);
            }
            return;
        }

        for (int i = start; i < 10 - turnedOn + index; i++) {
            isLight[i] = true;
            dfs(turnedOn, isLight, index+1, i+1);
            isLight[i] = false;
        }
    }

    private String isAns(boolean[] isLight){
        int hour = 0;
        for (int i = 3; i >= 0; i--) {
            // 计算小时
            if (isLight[i]){
                hour += Math.pow(2, i);
            }
        }
        if (hour > 11){
            return "";
        }
        int minute = 0;
        for (int i = 9; i >= 4; i--) {
            if (isLight[i]){
                minute += Math.pow(2, i-4);
            }
        }
        if (minute > 59){
            return "";
        }

        return hour + ":" + String.format("%02d", minute);
    }
}
