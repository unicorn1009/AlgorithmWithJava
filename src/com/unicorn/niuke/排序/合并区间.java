package com.unicorn.niuke.排序;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * <p>
 * </p>
 * Created on 2021/04/19 21:40
 *
 * @author Unicorn
 */
public class 合并区间 {
    public static void main(String[] args) {
        // [[150,180],[1,60],[10,30],[80,100]]
        ArrayList<Interval> list = new ArrayList<Interval>() {{
            add(new Interval(1, 4));
            add(new Interval(1, 4));
        }};
        ArrayList<Interval> ans = merge(list);
        System.out.println(ans);

    }

    /**
     * Definition for an interval.
     * public class Interval {
     * int start;
     * int end;
     * Interval() { start = 0; end = 0; }
     * Interval(int s, int e) { start = s; end = e; }
     * }
     */
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() < 2) return intervals;
        // 先排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                } else {
                    return o1.start - o2.start;
                }
            }
        });

        Interval last = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start <= last.end) {
                last.end = Math.max(last.end, cur.end);
                cur.start = 0;
                cur.end = -1;
            } else {
                last = cur;
            }
        }

        intervals.removeIf(next -> next.start == 0 && next.end == -1);

        return intervals;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}