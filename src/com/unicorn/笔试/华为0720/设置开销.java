package com.unicorn.笔试.华为0720;

import com.unicorn.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-07-21 9:47 下午
 */
public class 设置开销 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String line = sc.next();
            String[] split = line.split("],\\[");
            split[0] = split[0].substring(2);
            split[split.length-1] = split[split.length-1].substring(0,split[split.length-1].length()-2);
            List<int[]> list = new ArrayList<>();
            for (String s : split) {
                int[] arr = new int[3];
                String[] nums = s.split(",");
                for (int i = 0; i < nums.length; i++) {
                    arr[i] = Integer.parseInt(nums[i]);
                }
                list.add(arr);
            }
            int[][] input = list.toArray(new int[list.size()][]);
            // int[][] input = {{1, 2, 5}, {1, 3, 5},{4,2,10},{2,5,5},{3,4,10},{3,7,10},{4,7,5},{5,6,5},{6,7,5}};
            int nodeNum = 0;
            for (int[] ints : input) {
                nodeNum = Math.max(ints[0], nodeNum);
                nodeNum = Math.max(ints[1], nodeNum);
            }
            int[][] graph = new int[nodeNum][nodeNum];
            for (int[] ints : input) {
                graph[ints[0] - 1][ints[1] - 1] = ints[2];
            }
            System.out.println(maxValue(graph));
        }
        // [[1,2,5],[1,3,5],[4,2,10],[2,5,5],[3,4,10],[3,7,10],[4,7,5],[5,6,5],[6,7,5]]
    }

    public static int maxValue(int[][] graph){
        for (int i = 0; i < graph.length; i++) {
            int inDegree = 0;
            for (int[] ints : graph) {
                inDegree += ints[i];
            }
            if (inDegree==0){
                // 从当前入度为0的节点出发,即节点i
                boolean[] vis = new boolean[graph.length];
                vis[i] = true;
                dfs(graph, vis, i, 0);
            }
        }
        return maxV;
    }

    private static int maxV;

    public static void dfs(int[][] graph, boolean[] vis,int curNode, int curProd){
        if (curProd > maxV){
            maxV = curProd;
        }
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i] && graph[curNode][i] != 0){
                // 可以走
                vis[i] = true;
                dfs(graph, vis, i, curProd+graph[curNode][i]);
                vis[i] = false;
            }
        }
    }
}
