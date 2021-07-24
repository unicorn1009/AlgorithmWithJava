package com.unicorn.笔试.huawei;

import com.unicorn.common.Array;
import com.unicorn.util.ArrayUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

/**
 * <p>
 * </p>
 * Created on 2021/07/21 19:10
 *
 * @author Unicorn
 */
public class T01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int n = input.nextInt();
            int k = input.nextInt();
            int[][] s = new int[k][2];
            for (int i = 0; i < k; i++) {
                s[i][0] = input.nextInt();
                int start = input.nextInt();
                int end = input.nextInt();
                int m = Math.min(end-start, n-(end - start));
                s[i][1] = m*5+s[i][0];
            }
            System.out.println(method(s));
        }
    }

    public static int method(int[][] s){
        if (s.length == 0)
            return 0;
        Arrays.sort(s, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]){
                    return 1;
                }else if (point1[1] < point2[1]){
                    return -1;
                }else
                    return 0;
            }
        });
        int ans = 1;
        for (int i = 1; i < s.length; i++) {
            int l = 1;
            for (int j = i-1; j >= 0; j--) {
                if (s[i][0] < s[j][1])
                    l++;
                ans = Math.max(ans, l);
            }
        }
        return ans;
    }

    public int findMin(int[][] points){
        if(points.length == 0){
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]){
                    return 1;
                }else if (point1[1] < point2[1]){
                    return -1;
                }else
                    return 0;
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] point : points) {
            if (point[0] > pos){
                pos = point[1];
                ++ans;
            }
        }
        return ans;
    }

    public static int m1(int[][] guests){
        int n = guests.length;
        Interval[] intervals = new Interval[guests.length];
        int i = 0;
        for (int k = 0; k < n; k++) {
            intervals[i*2] = new Interval(guests[k][0], 0);
            intervals[i*2+1] = new Interval(guests[k][1], 1);
            i++;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val > o2.val){
                    return 1;
                }else {
                    if (o1.type == o2.type){
                        return 0;
                    }else {
                        if (o1.type > o2.type){
                            return -1;
                        }else {
                            return 1;
                        }
                    }
                }
            }
        });
        int max = 1;
        int count = 0;
        for (int j = 0; j < 2 * n; j++) {
            if (intervals[j].type==0){
                count++;
                max = Math.max(max, count);
            }else {
                count--;
            }
        }
        return max;
    }

    public static class Interval{
        public int type;
        public int val;

        public Interval(int type, int val) {
            this.type = type;
            this.val = val;
        }


    }
}
