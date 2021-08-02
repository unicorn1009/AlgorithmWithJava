package com.unicorn.笔试.阿里巴巴.秋招2021;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 * </p>
 * Created on 2021-7-16.
 *
 * @author Unicorn
 */
public class 小强去春游 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();
        while (group-->0){
            int num = sc.nextInt();
            int[] weights = new int[num+1];
            int c = num;
            while (c-->0){
                weights[num-c] = sc.nextInt();
            }
            AcrossRiver(weights, num);
        }
    }

    public static void AcrossRiver(int[] weights, int n){
        Arrays.sort(weights);
        long ans = 0;

        while(n>=4)
        {
            ans+=Math.min(weights[1]*2+weights[n-1]+weights[n],weights[1]+2*weights[2]+weights[n]);
            n-=2;
        }
        if(n==3)
            ans+=weights[1]+weights[2]+weights[3];
        else if(n==2)
            ans+=weights[2];
        else if(n==1)
            ans+=weights[1];

        System.out.println(ans);
    }
}
