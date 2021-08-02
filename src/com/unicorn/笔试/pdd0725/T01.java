package com.unicorn.笔试.pdd0725;

import java.util.*;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-07-25 7:02 下午
 */
public class T01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int lineNums = sc.nextInt();
            int[][] lines = new int[lineNums][];
            for (int i = 0; i < lineNums; i++) {
                int[] line =  new int[2];
                line[0] = sc.nextInt();
                line[1] = sc.nextInt();
                lines[i] = line;
            }
            System.out.println(isContain(lines));
        }
    }

    public static boolean isContain(int[][] lines){
        List<int[]> list = new ArrayList<>();
        Arrays.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                else {
                    return o1[1]-o2[1];
                }
            }
        });
        for (int[] line : lines) {
            if (list.isEmpty()){
                list.add(line);
            }else {
                for (int[] curLine : list) {
                    if (line[0] >= curLine[0] && line[1] <= curLine[1]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
