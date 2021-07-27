package com.unicorn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(5);
        integers.add(3) ;
        Collections.sort(integers);
        integers.add(2);
        Collections.reverse(integers);
        System.out.println(integers);

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
        if(n<=0) return;
        t.p1 += 1;
        t.p2 += 'a';
        m1(t, n-1);
        System.out.print(t.p1);
        System.out.print("-");
        System.out.println(t.p2);
    }

    @org.junit.jupiter.api.Test
    public void t1(){
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
        Test[] arrTest = {new Test(1,"aaa"), new Test(2, "bbb")};
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

class Test{
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
