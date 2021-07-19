package com.unicorn.笔试.阿里2021秋招;

import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * </p>
 * Created on 2021-7-15.
 *
 * @author Unicorn
 */
public class 树上最短链 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodeNums = sc.nextInt();
        boolean[][] nodes = new boolean[nodeNums+1][nodeNums+1];
        int[] nodeLevels = new int[nodeNums+1];
        for (int i = 1; i <= nodeNums; i++) {
            nodeLevels[i] = sc.nextInt();
        }
        while (nodeNums-- > 1){
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            nodes[a1][a2] = true;
            nodes[a2][a1] = true;
        }

        int ans = minCost(nodes, nodeLevels, nodeLevels.length-1);
        if (ans == Integer.MAX_VALUE-5001)
            System.out.println(-1);
        else
            System.out.println(ans);
    }

    public static int minCost(boolean[][] nodes, int[] nodeLevels, int nodeNums){
        int min = Integer.MAX_VALUE-5001;
        for (int i = 1; i <= nodeNums; i++) {
            min = Math.min(min, dfs(nodes, nodeLevels,i, i));
        }
        return min;
    }

    // 返回从curNode出发, 走到与某个level城市的最短路径长度
    public static int dfs(boolean[][] nodes, int[] nodeLevels,int startNode, int curNode){
        if (curNode != startNode && nodeLevels[startNode] == nodeLevels[curNode]){
            return 0;
        }
        int min = Integer.MAX_VALUE-5001;
        // 只往比自己大的地方走, 保证不走回头路
        for (int i = curNode+1; i < nodes[curNode].length; i++) {
            if (nodes[curNode][i]){
                // 有边
                int curCost = dfs(nodes, nodeLevels,startNode, i);
                min = Math.min(min, curCost+1);
            }
        }
        return min;
    }
}
