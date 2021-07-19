package com.unicorn.Leetcode;

import com.unicorn.dataStructure.stageOne.graph.Graph;

import java.util.Stack;

/**
 * <p>
 *     210. 课程表 II
 * </p>
 * Created on 2021-7-18.
 *
 * @author Unicorn
 */
public class Solution0210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        for (int[] prerequisite : prerequisites) {
            graph.addEdge(prerequisite[1], prerequisite[0], 1);
        }
        return topologicalSort(graph);
    }

    int[] topologicalSort(Graph G){
        // 构造一个入度数组
        int[] indegree = new int[G.nodeNum];
        for (int i = 0; i < G.nodeNum; i++) {
            for (int j = 0; j < G.nodeNum; j++) {
                if (G.edges[i][j]  == 1)
                    indegree[j]++;
            }
        }

        // 初始化一个入度为0的节点栈
        Stack<Integer> S = new Stack<>();
        for (int i = 0; i < G.nodeNum; i++) {
            if (indegree[i] == 0){
                S.push(i);
            }
        }

        int count = 0;  // 输出节点的个数
        int[] ans = new int[G.nodeNum];

        // 输出拓扑排序
        while (!S.isEmpty()){
            Integer v = S.pop();
            ans[count++] = v;
            // 将所有v指向的节点入度-1
            for (int i = 0; i < G.nodeNum; i++) {
                if (G.edges[v][i] == 1){
                    if (--indegree[i] == 0){
                        S.push(i);
                    }
                }
            }
        }

        if (count == G.nodeNum)
            return ans;
        else
            return new int[0];
    }
}
