package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     79. 单词搜索
 * </p>
 * Created on 2021/3/11.
 *
 * @author Unicorn
 */
public class Solution0079 {
    public static void main(String[] args) {
        char[][] chars = new char[3][3];
        chars[0] = new char[]{'A','B','C','E'};
        chars[1] = new char[]{'S','F','C','S'};
        chars[2] = new char[]{'A','D','E','E'};

        System.out.println(new Solution0079().exist(chars, "SEE"));
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    boolean[][] vis = new boolean[board.length][board[0].length];
                    // 找到一个可能的起点
                    vis[i][j] = true;  // 标记已走过
                    boolean isOk = dfs(word, 1, i, j, vis, board);
                    vis[i][j] = false;
                    if (isOk)
                        return true;
                }
            }
        }
        return false;
    }

    private final int[] X = {0, 0, -1, 1};
    private final int[] Y = {-1, 1, 0, 0};
    private boolean dfs(String word, int depth,int x, int y, boolean[][] vis, char[][] board){
        if (depth == word.length()){
            return true;
        }
        for (int i = 0; i < 4; i++) {
            x = x + X[i];
            y = y + Y[i];
            if (x>=0 && x < board.length && y>=0 && y < board[0].length && !vis[x][y] && board[x][y] == word.charAt(depth)){
                vis[x][y] = true;
                boolean found = dfs(word, depth+1, x, y, vis, board);
                if (found) return true;
                vis[x][y] = false;
            }
            x = x - X[i];
            y = y - Y[i];
        }

        return false;

    }


}
