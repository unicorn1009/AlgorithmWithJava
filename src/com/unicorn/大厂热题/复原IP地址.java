package com.unicorn.大厂热题;

import java.util.*;

/**
 * <p>
 * </p>
 * Created on 2021-8-3.
 *
 * @author Unicorn
 */

public class 复原IP地址 {
    public static void main(String[] args) {
        复原IP地址 aaa = new 复原IP地址();
        System.out.println(aaa.isIp("101023"));
    }

    private List<String> ans = new ArrayList<>();

    public List<String> isIp(String s) {

        int n = s.length();
        if (n > 12 || n < 4) return ans;

        // 队列
        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, 0, 4, path);
        return ans;
    }

    private void dfs(String s, int start, int segment, Deque<String> path) {

        int n = s.length();
        if (start == n && segment == 0) {
            StringBuilder sb = new StringBuilder();
            for (String str : path) {
                sb.append(str).append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            ans.add(sb.toString());
            return ;
        }

        // 最多3位组成一个段， i位当前段的尾部下标
        for (int i=start;i<start+3;i++) {

            if (i >= n) break;
            // 判断剩下的字符串长度是否比要组成的段的最大长度还长，如果是，则当前答案无效，继续下一次循环
            if (segment * 3 < n - i) continue;


            if (isIpSegment(s, start, i)) {
                // 当前段有效，加入队列
                String currentSegment = s.substring(start, i + 1);
                path.addLast(currentSegment);
                // 关键， 下一段从下标为i+1的位置开始，总段数-1
                dfs(s, i + 1, segment - 1, path);
                // 回溯
                path.removeLast();
            }
        }
    }

    private boolean isIpSegment(String s, int left, int right) {

        // 如果字符串长度大于1， 且第一位是0，则不可为ip段
        if (right - left + 1 > 1 && s.charAt(left) == '0') return false;

        int res = Integer.parseInt(s.substring(left, right+1));

        return res >= 0 && res <= 255;
    }

}
