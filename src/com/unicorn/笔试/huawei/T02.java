package com.unicorn.笔试.huawei;

import com.unicorn.util.ArrayUtil;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * <p>
 * </p>
 * Created on 2021/07/21 19:38
 *
 * @author Unicorn
 */
public class T02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] nm = new int[N];
            int[][] arr =  new int[K][2];
            for (int i = 0; i < K; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1]==o2[1]) return o2[0]-o1[0];
                    return o1[1]-o2[1];
                }
            });
            int[] kmm = new int[K];
            for (int i = 0; i < K; i++) {
                kmm[i] = arr[i][0];
            }
            int idx = 0;
            int ans = 0;
            while (idx<K){
                for (int i = 0; i < nm.length; i++) {
                    if (nm[i] == 0){
                        nm[i] = kmm[idx];
                        idx+=1;
                        continue;
                    }
                    if (i==nm.length-1 && nm[i] != 0){
                        int id = minIndex(nm);
                        ans+=nm[id];
                        for (int j = 0; j < nm.length; j++) {
                            nm[j] = nm[id];
                        }
                        idx+=1;
                        continue;
                    }
                }

            }
            ans+=max(nm);
            System.out.println(ans);
        }
    }

    private static int minIndex(int[] arr) {
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]){
                minIndex = i;
            }
        }
        return minIndex;
    }
    public static int max(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }

        }
        return max;
    }
}
