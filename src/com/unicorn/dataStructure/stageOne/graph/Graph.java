package com.unicorn.dataStructure.stageOne.graph;

/**
 * <p>
 * </p>
 * Created on 2021-7-18.
 *
 * @author Unicorn
 */
public class Graph {
    public double[][] edges;
    public int nodeNum;
    public int edgeNum;

    public Graph(int nodeNum) {
        edges = new double[nodeNum][nodeNum];
        this.nodeNum = nodeNum;
        this.edgeNum = 0;
    }

    public Graph(double[][] edges, int nodeNum, int edgeNum) {
        this.edges = edges;
        this.nodeNum = nodeNum;
        this.edgeNum = edgeNum;
    }

    public void addEdge(int i, int j, double w){
        this.edges[i][j] = w;
        this.edgeNum++;
    }


}
