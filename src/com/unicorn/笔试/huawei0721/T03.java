package com.unicorn.笔试.huawei0721;

import java.util.Scanner;

/**
 * <p>
 * </p>
 * Created on 2021/07/21 20:01
 *
 * @author Unicorn
 */
public class T03 {
    public static void main(String[] args) {
        int[][] arr =new int[][]{{1,2,5}, {1,3,5}, {4,2,10}, {2,5,5},
                {3,4,10},{3,7,10},{4,7,5},{5,6,5},{6,7,5}};
        Scanner sc = new Scanner(System.in);

        System.out.println(solution(arr));
    }
    public static int solution(int[][] paths){
        int n = paths.length;
        int maxNodeN0 = 0;
        for (int i = 0; i < n; i++) {
            if (paths[i][0] > maxNodeN0) maxNodeN0=paths[i][0];
            if (paths[i][1] > maxNodeN0) maxNodeN0=paths[i][1];
        }
        int nodeNum = maxNodeN0 + 1;
        int[][] matrix = new int[nodeNum][nodeNum];
        for (int i = 0; i < n; i++) {
            matrix[paths[i][0]][paths[i][1]] = paths[i][2];
        }
        boolean[] vis = new boolean[nodeNum];
        int rs = 0;
        for (int i = 0; i < matrix.length; i++) {
            rs = Math.max(rs, dfs(matrix, vis, i, 0));
        }
        return rs;
    }

    public static int dfs(int[][] matrix, boolean[] vis , int cur, int len){
        int rs = len;
        for (int next = 0; next < matrix.length; next++) {
            if (vis[next] || matrix[cur][next] == 0) continue;
            vis[next] = true;
            int newLen = dfs(matrix, vis, next, len+matrix[cur][next]);
            vis[next] = false;
            if (newLen > rs) rs = newLen;
        }
        return rs;
    }
}
