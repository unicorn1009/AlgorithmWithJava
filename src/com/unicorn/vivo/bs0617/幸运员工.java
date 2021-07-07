package com.unicorn.vivo.bs0617;

/**
 * <p>
 *     // 输入员工编号, 找出编号中包含7或者是7的倍数的员工数量
 * </p>
 * Created on 2021/6/17.
 *
 * @author Unicorn
 */
public class 幸运员工 {
    public static void main(String[] args) {
        System.out.println(luckyStaff(new Integer[]{105140}));
    }

    public static int luckyStaff(Integer[] staffs){
        int ret = 0;
        for (Integer staff_id : staffs) {
            if (staff_id == 7 || staff_id % 7 == 0){
                ret++;
            }
        }
        return ret;
    }
}
