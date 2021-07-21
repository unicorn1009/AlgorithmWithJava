package com.unicorn.笔试.huawei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * <p>
 * </p>
 * Created on 2021/07/21 20:46
 *
 * @author Unicorn
 */
public class T011 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            int k = input.nextInt();
            int[][] s = new int[k][2];
            for (int i = 0; i < k; ++i) {
                s[i][0] = input.nextInt();
                int startId = input.nextInt();
                int endId = input.nextInt();
                int m = Math.min(endId-startId, n-(endId-startId));
                s[i][1] = m * 5 + s[i][0];
            }
            System.out.println(method(s));
        }
    }

    public static int method(int[][] guests){
        int n = guests.length;
        Interval[] intervals = new Interval[n*2];
        int i = 0;
        for (int k=0; k<n; k++){
            intervals[i*2] = new Interval(guests[k][0], 0);
            intervals[i*2+1] = new Interval(guests[k][1], 1);
            i++;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.val < o2.val){
                    return -1;
                } else if (o1.val > o2.val){
                    return 1;
                } else {
                    if (o1.type == o2.type){
                        return 0;
                    } else {
                        // 由于类似[3, 5), [5, 6)这种不算是重合区间, 所以在排序时要保证在两个val相同时, type=1要在type=0前
                        if (o1.type > o2.type){
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                }
            }
        });
        // 核心代码
        int max = 1;
        int count = 0;
        for (int j=0;j<2*n;j++){
            if (intervals[j].type == 0){
                count++;
                max = Math.max(max, count);
            } else {
                // 说明某个区间已经闭合, 所以总计数应该减少1
                count--;
            }
        }
        return max;

    }

    static class Interval {
        public int type;
        public int val;

        public Interval(int type, int val) {
            this.type = type;
            this.val = val;
        }
    }
    
}
