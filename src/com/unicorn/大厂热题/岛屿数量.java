package com.unicorn.大厂热题;

import com.unicorn.util.ArrayUtil;

/**
 * <p>
 *     200. 岛屿数量
 * </p>
 * Created on 2021-7-24.
 *
 * @author Unicorn
 */
public class 岛屿数量 {

    public static void main(String[] args) {
        ArrayUtil.ArrayConvert("[[\"1\",\"1\",\"0\",\"0\",\"0\"],[\"1\",\"1\",\"0\",\"0\",\"0\"],[\"0\",\"0\",\"1\",\"0\",\"0\"],[\"0\",\"0\",\"0\",\"1\",\"1\"]]");
        System.out.println("{{\"1\",\"1\",\"0\",\"0\",\"0\"},{\"1\",\"1\",\"0\",\"0\",\"0\"},{\"0\",\"0\",\"1\",\"0\",\"0\"},{\"0\",\"0\",\"0\",\"1\",\"1\"}}".replace("\"", "'"));
        char[][] map = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        岛屿数量 aaa = new 岛屿数量();
        System.out.println(aaa.numIslands(map));

    }


    public int numIslands(char[][] grid) {
        vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !vis[i][j]){
                    vis[i][j] = true;
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;

    }

    public boolean[][] vis;
    public int[] xDirection = {1, 0, 0, -1};
    public int[] yDirection = {0, -1, 1, 0};
    public int ans = 0;

    public void dfs(char[][] grid, int row, int col){
        for (int i = 0; i < 4; i++) {
            int nextX = row+xDirection[i];
            int nextY = col+yDirection[i];
            if (!(nextX >= grid.length || nextX < 0 || nextY >= grid[0].length || nextY < 0) && !vis[nextX][nextY] && grid[nextX][nextY] == '1') {
                vis[nextX][nextY] = true;
                dfs(grid, nextX, nextY);
            }
        }
    }
}
