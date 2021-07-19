package com.unicorn.dataStructure.stageOne.graph;

import java.util.Stack;

/**
 * <p>
 * </p>
 * Created on 2021-7-18.
 *
 * @author Unicorn
 */
public class 拓扑排序 {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 3, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 4, 1);
        graph.addEdge(3, 2, 1);
        graph.addEdge(3, 4, 1);

        boolean b = TopologicalSort(graph);
        System.out.println(b);
    }

    static boolean TopologicalSort(Graph G){
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

        // 输出拓扑排序
        while (!S.isEmpty()){
            Integer v = S.pop();
            System.out.print(v+1 + " ");
            count++;
            // 将所有v指向的节点入度-1
            for (int i = 0; i < G.nodeNum; i++) {
                if (G.edges[v][i] == 1){
                    if (--indegree[i] == 0){
                        S.push(i);
                    }
                }
            }
        }

        return count == G.nodeNum;
    }
}
