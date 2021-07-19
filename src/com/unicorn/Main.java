package com.unicorn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();
        while (group-- > 0) {
            int num = sc.nextInt();
            Integer[] weights = new Integer[num];
            int c = num;
            while (c-- > 0) {
                weights[num - c -1] = sc.nextInt();
            }
            int ans = minTime(weights);
            System.out.println(ans);
        }
    }

    public static int minTime(Integer[] weights) {
        Arrays.sort(weights, Collections.reverseOrder());
        int ans = 0;
        for (int i = 0; i < weights.length; i+=2) {
            ans += weights[i];
        }
        if (weights.length % 2 == 1)
            ans+=weights[weights.length-1];
        return ans;
    }

    @org.junit.jupiter.api.Test
    public void t2() {
        Test t = new Test(1, "a");
        m1(t, 4);
    }

    private void m1(Test t, int n) {
        System.out.print(t.p1);
        System.out.print("-");
        System.out.println(t.p2);
        if (n <= 0) return;
        t.p1 += 1;
        t.p2 += 'a';
        m1(t, n - 1);
        System.out.print(t.p1);
        System.out.print("-");
        System.out.println(t.p2);
    }

    @org.junit.jupiter.api.Test
    public void t1() {
        System.out.println("hello");
        String[] arr = {"aaa", "bbb"};
        String[] clone = arr.clone();
        System.out.println(arr == clone);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(clone));
        clone[0] = "ccc";
        System.out.println("----------------");
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(clone));
        System.out.println("----------------");
        Test[] arrTest = {new Test(1, "aaa"), new Test(2, "bbb")};
        Test[] clone1 = arrTest.clone();
        System.out.println(arrTest == clone1);
        System.out.println(Arrays.toString(arrTest));
        System.out.println(Arrays.toString(clone1));
        System.out.println("----------------");
        clone1[0].setP1(999);
        System.out.println(Arrays.toString(arrTest));
        System.out.println(Arrays.toString(clone1));
    }

}

class Test {
    public Integer p1;
    public String p2;

    public Test(Integer p1, String p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "Test{" +
                "p1=" + p1 +
                ", p2='" + p2 + '\'' +
                '}';
    }

    public Integer getP1() {
        return p1;
    }

    public void setP1(Integer p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }
}
