package com.unicorn.Leetcode.week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/03/21 11:12
 *
 * @author Unicorn
 */
public class 积压订单中的订单总数 {
    public static void main(String[] args) {
        int[][] orders = {{1, 25, 1}, {8, 9, 0}, {26, 20, 0}, {12, 10, 0}, {6, 6, 1}, {17, 6, 1}, {21, 23, 1}, {15, 23, 1}};
        System.out.println(new 积压订单中的订单总数().getNumberOfBacklogOrders(orders));
    }
    public int getNumberOfBacklogOrders(int[][] orders) {
        List<int[]> jiYas = new ArrayList<>();

        getNumberOfBacklogOrders1(orders, jiYas);


        long ans = 0;
        for (int[] jiYa : jiYas) {
            ans += jiYa[1];
        }
        return (int)(ans% 1000000007);
    }
    public void getNumberOfBacklogOrders1(int[][] orders, List<int[]> jiYas) {
        boolean flag = true;
        for (int[] order : orders) {
            if (order[1] > 0){
                // 未处理完
                flag = false;
                break;
            }
        }
        if (flag) return;

        for (int[] order : orders) {
            if (order[1] ==0 ) continue;

            if (jiYas.size() == 0){
                jiYas.add(Arrays.copyOf(order, order.length));
                order[1] = 0;
            }else {
                if (order[2] == 0){
                    // 0订单, 找价格更小的1订单
                    int index = -1;
                    for (int i = 0; i < jiYas.size() ; i++) {

                        // 找 1 订单
                         if (jiYas.get(i)[2] == 1 && jiYas.get(i)[0] <= order[0]){
                             // 找 1 中价格最低的
                             if (index == -1){
                                 index = i;
                             }else {
                                 if (jiYas.get(i)[0] <= jiYas.get(index)[0])
                                     index = i;
                             }
                         }
                    }

                    if (index == -1 || jiYas.get(index)[0] > order[0]){
                        // 没找到价格更小的1订单
                        jiYas.add(Arrays.copyOf(order, order.length));
                        order[1] = 0;
                    }else {

                        // 找到 最低价格的1订单index
                        if (jiYas.get(index)[1] <= order[1]){
                            // 消除当前积压订单
                            order[1] = order[1] - jiYas.get(index)[1];
                            jiYas.remove(index);
                        }else {
                            // 1订单数量比当前来的0订单更多
                            int[] jiyaOrder = jiYas.get(index);
                            jiyaOrder[1] = jiyaOrder[1] - order[1];
                            jiYas.set(index, jiyaOrder);
                            order[1] = 0;
                        }
                    }


                }else {
                    // 1订单, 找价格更大的0订单
                    int index = -1;
                    for (int i = 0; i < jiYas.size(); i++) {
                        // 找 0 订单
                        if (jiYas.get(i)[2] == 0 && jiYas.get(i)[0] >= order[0]){
                            // 找 0 中价格最高的
                            if (index == -1){
                                index = i;
                            }else {
                                if (jiYas.get(i)[0] >= jiYas.get(index)[0])
                                    index = i;
                            }
                        }
                    }

                    if (index == -1 || jiYas.get(index)[0] < order[0]){
                        // 没找到价格更小的1订单
                        jiYas.add(Arrays.copyOf(order, order.length));
                        order[1] = 0;
                    }else {

                        // 找到 最高价格的0订单index
                        if (jiYas.get(index)[1] <= order[1]){
                            // 消除当前积压订单
                            order[1] -= jiYas.get(index)[1];
                            jiYas.remove(index);
                        }else {
                            // 1订单数量比当前来的0订单更多
                            int[] jiyaOrder = jiYas.get(index);
                            jiyaOrder[1] = jiyaOrder[1] - order[1];
                            jiYas.set(index, jiyaOrder);
                            order[1] = 0;
                        }
                    }

                }
            }
        }

        // 走完一遍订单后, 还需要继续走, 以使得orders内所有订单数为0
        getNumberOfBacklogOrders1(orders, jiYas);
    }
}
