package com.unicorn.Leetcode.group;

import com.unicorn.common.Array;
import com.unicorn.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/04/10 15:30
 *
 * @author Unicorn
 */
public class G5 {
    public static void main(String[] args) {
        System.out.println(ArrayUtil.ArrayConvert("[[2,3],[3,0],[4,1]]"));
        int[][] ps = new int[][]{{2,3},{2,1}};
        System.out.println(minRecSize1(ps));

    }
    public static double minRecSize(int[][] lines) {
        List<double[]> interPoints = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            for (int j = i+1; j < lines.length; j++) {
                // 判断i，j两直线是否有交点, k相同则无交点
                if (lines[i][0] == lines[j][0])
                    continue;
                double x = (lines[j][1] - lines[i][1]) * 1.0 / (lines[i][0] - lines[j][0]);
                double y = x * lines[i][0] + lines[i][1];
                interPoints.add(new double[]{x,y});
            }
        }

        // 已有所有交点

        // 1. 只有一个交点
        if (interPoints.size() <= 1)
            return 0;

        // 求出所有交点中，最小和最大的x，最小和最大的y
        double minX = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double minY = Double.MAX_VALUE;
        double maxY = Double.MIN_VALUE;
        for (double[] point : interPoints) {
//            System.out.println(Arrays.toString(point));
            minX = Math.min(point[0], minX);
            maxX = Math.max(point[0], maxX);
            minY = Math.min(point[1], minY);
            maxY = Math.max(point[1], maxY);
        }

        return (maxX - minX) * (maxY - minY);
    }

    public static double minRecSize1(int[][] lines) {
        final double threshold = .00001;
        double minX = Double.MAX_VALUE;
        double maxX = -Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxY = -Double.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i < lines.length; i++) {
            for (int j = i+1; j < lines.length; j++) {
                // 判断i，j两直线是否有交点, k相同则无交点
                if (lines[i][0] == lines[j][0])
                    continue;
                flag = true;
                double x = (lines[j][1] - lines[i][1]) * 1.0 / (lines[i][0] - lines[j][0]);
                double y = x * lines[i][0] + lines[i][1];
                minX = Math.min(x, minX);
                maxX = Math.max(x, maxX);
                minY = Math.min(y, minY);
                maxY = Math.max(y, maxY);
            }
        }

        // 没有交点
        if (!flag){
            return 0;
        }

        // 只有一个交点
        if (Math.abs(minX - maxX) < threshold && Math.abs(minY - maxY) < threshold)
            return 0;

        return (maxX - minX) * (maxY - minY);
    }
}
