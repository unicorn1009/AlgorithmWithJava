package com.unicorn.Leetcode;

/**
 * <p>
 *     1603. 设计停车系统
 * </p>
 *
 * @author unicorn
 * @create 2021-04-05 11:04 下午
 */
public class Solution1603 {

}
class ParkingSystem {
    private int bigRemain;
    private int mediumRemain;
    private int smallRemain;

    public ParkingSystem(int big, int medium, int small) {
        bigRemain = big;
        mediumRemain = medium;
        smallRemain = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1){
            if (bigRemain > 0){
                bigRemain -- ;
                return true;
            }else {
                return false;
            }
        }else if (carType == 2){
            if (mediumRemain > 0){
                mediumRemain -- ;
                return true;
            }else {
                return false;
            }
        }else {
            if (smallRemain > 0){
                smallRemain -- ;
                return true;
            }else {
                return false;
            }
        }
    }
}
