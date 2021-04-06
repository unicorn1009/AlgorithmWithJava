package com.unicorn.Leetcode.lcp;

/**
 * <p>
 * </p>
 * Created on 2021/04/06 09:53
 *
 * @author Unicorn
 */
public class LCP029 {
    public static void main(String[] args) {
        System.out.println(orchestraLayout(392885312
                ,259226065,
                336887518));
    }

    public static int orchestraLayout(int num, int xPos, int yPos) {

        // 确定坐标所在层layer
        int layer = Math.min(Math.min(num - xPos - 1, xPos), Math.min(num - yPos - 1, yPos));
        // 第layer层的开始位置编号
        long sum = 0;
        for (int i = 0; i < layer; i++) {
            sum += 4 * (((long)num - i * 2) - 1);
        }
        int serial = (int) ((sum % 9)+1) ;
//        System.out.println(serial);
        // 第layer层的宽高
        int sideLen = num - layer * 2;

        // 求相对位置
        if (xPos == layer){
            // 说明位置在最上面一行
//            yPos-layer;
        }else if (xPos == num-layer-1){
            // 说明位置在最下面一行

        }else if (yPos == layer){
            // 说明位置在最左边一列
        }else if (yPos == num-layer-1){
            // 说明位置在最右边一列
        }


        return serial;
    }
}
