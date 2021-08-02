package com.unicorn.笔试.阿里巴巴.秋招2021;

import java.util.Scanner;

/**
 * <p>
 * </p>
 * Created on 2021-7-16.
 *
 * @author Unicorn
 */
public class 对称飞行器 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();
        int c = row;
        char[][] map = new char[row][];
        sc.nextLine();
        while (c-- > 0){
            String line = sc.nextLine();
            map[row-c-1] = line.toCharArray();
        }

        int ans = fly(map, row, col);
        System.out.println(ans);
    }

    public static int fly(char[][] map, int row, int col){
        boolean[][] isOver = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 'S'){
                    isOver[i][j] = true;
                    dfs(map, i, j, false, 0, isOver, 0);
                    if (minCost == Integer.MAX_VALUE)
                        return -1;
                    else
                        return minCost;

                }
            }
        }
        if (minCost == Integer.MAX_VALUE)
            return -1;
        else
            return minCost;
    }

    public static int minCost = Integer.MAX_VALUE;
    static int[] horizontal = new int[]{0,0,-1,1};
    static int[] vertical = new int[]{1,-1,0,0};

    public static void dfs(char[][] map, int curRow, int curCol, boolean isFly, int steps, boolean[][] isOver, int flyCount){
        if (curRow > map.length-1 || curCol > map[0].length-1 || curRow < 0 || curCol < 0 || steps > minCost){
            // 越界
            return;
        }
        if (map[curRow][curCol] == 'E'){
            // 到达终点
            if (steps < minCost)
                minCost = steps;
            return;
        }
        // 注意不能走回头路
        for (int i = 0; i < 4; i++) {
            int nextRow = curRow+vertical[i];
            int nextCol = curCol+horizontal[i];
            if (nextRow <= map.length-1 && nextRow>=0 && nextCol <= map[0].length-1 && nextCol>=0 && isOver[nextRow][nextCol] == false && map[nextRow][nextCol] != '#') {
                isOver[nextRow][nextCol] = true;
                dfs(map, nextRow, nextCol, false, steps + 1, isOver, flyCount);
                isOver[nextRow][nextCol] = false;
            }
        }
        // 如果上一步不是飞行操作, 则现在可以飞行
        // 最多飞5次
        if (!isFly){
            int flyRow = map.length-1-curRow;
            int flyCol = map[0].length-1-curCol;
            if (flyCount < 5 && flyRow <= map.length-1 && flyCol <= map[0].length-1 && isOver[flyRow][flyCol] == false && map[flyRow][flyCol] != '#') {
                isOver[flyRow][flyCol] = true;
                dfs(map, flyRow, flyCol, true, steps + 1, isOver, flyCount+1);
                isOver[flyRow][flyCol] = false;
            }
        }
    }
}
