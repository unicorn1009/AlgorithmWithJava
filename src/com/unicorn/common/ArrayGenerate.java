package com.unicorn.common;

import java.util.Random;

public class ArrayGenerate {
    private ArrayGenerate(){}

    public static Integer[] generateArrayOrdered(int n){
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static Integer[] generateArrayRandom(int n){
        Integer[] arr = new Integer[n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n);
        }

        return arr;
    }

    public static Integer[] generateArrayRandom(int n, int bound){
        Integer[] arr = new Integer[n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }

        return arr;
    }
}
