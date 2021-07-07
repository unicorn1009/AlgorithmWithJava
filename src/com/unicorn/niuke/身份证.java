package com.unicorn.niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * </p>
 * Created on 2021/04/15 20:23
 *
 * @author Unicorn
 */
public class 身份证 {
    public static void main(String[] args) {
        //3 2
        //333333333333333333
        //111111122222222222
        //111111133333333333
        //111111111000000000
        //000000000000000000
//        String[] ku = {"333333333333333333", "111111122222222222", "111111133333333333"};
//        query("000000000000000000", ku);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int Q = sc.nextInt();
        String[] ku = new String[n];
        for (int i = 0; i < n; i++) {
            ku[i] = sc.next();
        }
        for (int i = 0; i < Q; i++) {
            String id = sc.next();
            query(id, ku);
        }

    }

    public static void query(String id, String[] ku){
        List<Integer> allSim = new ArrayList<>();
        for (int i = 0; i < ku.length; i++) {
            allSim.add(similarity(id, ku[i]));
        }
        Collections.sort(allSim, Collections.reverseOrder());
        int count = 0;
        int maxSim = allSim.get(0);
        for (Integer sim : allSim) {
            if (sim == maxSim){
                count++;
            }else {
                break;
            }
        }
        System.out.println(maxSim + " " + count);



    }

    public static int similarity(String id1, String id2){
        int ans = 0;
        for (int i = 0; i < 18; i++) {
            if (id1.charAt(i) == id2.charAt(i)){
                ans++;
            }else {
                break;
            }
        }
        return ans;
    }
}
