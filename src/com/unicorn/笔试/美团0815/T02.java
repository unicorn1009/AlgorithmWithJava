package com.unicorn.笔试.美团0815;

import java.util.*;

/**
 * <p>
 * 构建回文串
 * 给出一个字符串, 问如果要使这个字符串变成回文串,最少需要在字符串末尾添加几个字符?
 * 输入输出示例:
 * 输入: abaaca 输出: 3
 * 输入: aba 输出: 0
 * 提示:
 * 输入不含空串, 字符串长度 < 1,000,000
 * </p>
 *
 * @author unicorn
 * @create 2021-08-15 7:25 下午
 */
public class T02 {
    public static void main(String[] args) {
        System.out.println(0.1+0.2);
//        miHaYou3(4,4,1,1,3,3,new char[][]{{'.','.','.','.'},{'.','.','#','.'},{'.','#','.','#'},{'.','.','.','#'}});
//        miHaYou3(2,2,1,1,2,2,new char[][]{{'.','.'},{'#','.'}});
//        miHaYou3(3,3,1,1,3,3,new char[][]{{'.','.','#'},{'.','#','.'},{'#','.','.'}});
    }



    // 米哈游0815-3
    static int[] horizontal = new int[]{0, 0, -1, 1};
    static int[] vertical = new int[]{1, -1, 0, 0};

    // n行, m列
    public static void miHaYou3(int n, int m, int x1, int y1, int x2, int y2, char[][] map) {
        x1--;x2--;y1--;y2--;
        boolean[][] vis = new boolean[n][m];
        Deque<Site> queue = new ArrayDeque<>();
        Set<Site> paiLei = new HashSet<>();
        paiLei.add(new Site(x2 - 1, y2 - 1));
        paiLei.add(new Site(x2 - 1, y2 + 1));
        paiLei.add(new Site(x2 + 1, y2 - 1));
        paiLei.add(new Site(x2 + 1, y2 + 1));
        paiLei.add(new Site(x2, y2 - 1));
        paiLei.add(new Site(x2, y2 + 1));
        paiLei.add(new Site(x2 - 1, y2));
        paiLei.add(new Site(x2 + 1, y2));
        int path = 0;
        queue.addLast(new Site(x1, y1));
        vis[x1][y1] = true;
        while (!queue.isEmpty()) {
            int num = queue.size();
            path++;
            for (int i = 0; i < num; i++) {
                Site curSite = queue.removeFirst();
                for (int j = 0; j < 4; j++) {
                    int x = curSite.x + horizontal[j], y = curSite.y + vertical[j];
                    if (x >= 0 && x < n && y >= 0 && y < m && map[x][y] == '.' && !vis[x][y]) {
                        vis[x][y] = true;
                        Site nextSite = new Site(x, y);
                        if (paiLei.contains(nextSite)){
                            // 到达排雷点,输出答案
                            System.out.println("path:"+path);
                            System.out.println((x1*x2)^(path)^(y1*y2));
                            return;
                        }
                        queue.addLast(nextSite);
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static class Site {
        public int x;
        public int y;

        public Site(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Site site = (Site) o;
            return x == site.x && y == site.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
