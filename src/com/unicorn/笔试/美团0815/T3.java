package com.unicorn.笔试.美团0815;

import java.util.*;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-08-15 8:28 下午
 */
public class T3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            Deque<Integer> queue = new ArrayDeque<>();
            List<Integer> l2r = new ArrayList<>();
            List<Integer> r2l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                // System.out.println(line);
                String[] s = line.split(" ");
                queue.addLast(Integer.parseInt(s[0]));
                if (s[1].equals("R")){
                    l2r.add(Integer.parseInt(s[0]));
                }else {
                    r2l.add(Integer.parseInt(s[0]));
                }
            }
            l2r.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            r2l.sort(((o1, o2) -> o1-o2));
            solution(l2r, r2l, queue);
        }

    }

    // l2r从大到小  r2l从小到大
    public static void solution(List<Integer> l2r, List<Integer> r2l, Deque<Integer> queue){
        Map<Integer, Integer> ansMap = new HashMap<>(); // 位置 - 爆炸时刻
        for (int j : l2r) {
            for (int k : r2l) {
                if (j < k) {
                    if ((k - j) % 2 == 0) {
                        // 会相遇爆炸
                        ansMap.put(j, (k - j) / 2);
                        ansMap.put(k, (k - j) / 2);
                    }
                }
            }
        }
        while (!queue.isEmpty()){
            System.out.println(ansMap.getOrDefault(queue.removeFirst(), -1));
        }
    }
}
