package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 *         56. 合并区间
 *         以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * </p>
 * Created on 2021-8-4.
 *
 * @author Unicorn
 */
public class Solution0056 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        // 按照区间第一位排序
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            // 列表为空或者列表中最后一个区间右边界小于当前区间左边界，则表示不能与列表中的区间合并，新添加一个区间
            if (ans.size() == 0 || ans.get(ans.size() - 1)[1] < L) {
                ans.add(new int[]{L, R});
            } else {    // 否则当前区间可以与列表中最后一个区间合并
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], R);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
