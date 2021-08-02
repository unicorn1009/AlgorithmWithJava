package com.unicorn.笔试.华为0720;

import java.util.Scanner;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-07-21 10:37 下午
 */
public class 自动驾驶出租车订单分配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] timeline = new int[1000 + N / 2 * 5];
            for (int i = 0; i < K; i++) {
                int timeBegin = sc.nextInt();
                int startId = sc.nextInt();
                int endId = sc.nextInt();
                int timeSpan = minTime(N, startId, endId) - 1;
                while (timeSpan > 0){
                    timeline[timeBegin++]+=1;
                    timeSpan--;
                }
            }
            int ans = 0;
            for (int i = 0; i < timeline.length; i++) {
                ans = Math.max(ans, timeline[i]);
            }
            System.out.println(ans);
        }
    }
    private static int minTime(int stationNum, int startId, int endId) {
        int min = Math.min(startId, endId);
        int max = Math.max(startId, endId);
        int span = max - min;
        if (span <= stationNum / 2) {
            // 顺时针
            return span * 5;
        }else {
            // 逆时针
            return ((stationNum-max)+min)*5;
        }
    }
}
