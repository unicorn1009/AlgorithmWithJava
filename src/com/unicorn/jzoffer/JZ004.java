package com.unicorn.jzoffer;

/**
 * <p>
 *     二维数组中的查找
 * </p>
 * Created on 2021/2/23.
 *
 * @author Unicorn
 */
public class JZ004 {
    public static void main(String[] args) {
        int i = 20000;
        int[][] arr = genArr(i);
        long startTime = System.nanoTime();
        System.out.println(new JZ004().findNumberIn2DArray(arr, arr[i-1][i-1]));
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.printf("二分查找：len = %d, time = %f s",i, time);

        System.out.println("\n");

        startTime = System.nanoTime();
        System.out.println(new JZ004().findNumberIn2DArray1(arr, arr[i-1][i-1]));
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.printf("暴力解： len = %d, time = %f s",i, time);

        System.out.println("\n");

        startTime = System.nanoTime();
        System.out.println(new JZ004().Find(arr[i-1][i-1],arr));
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.printf("cs-note： len = %d, time = %f s",i, time);
    }

    public boolean Find(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1; // 从右上角开始
        while (r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c])
                return true;
            else if (target > matrix[r][c])
                r++;
            else
                c--;
        }
        return false;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 如果是空矩阵 返回false
        if (matrix.length==0 || matrix[0].length==0) return false;
        // 如果矩阵中只有一个值
        if (matrix.length == 1 && matrix[0].length==1) return matrix[0][0] == target;
        return binarySearch(matrix, target, 0,0,matrix.length-1, matrix[0].length-1);
    }

    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        // 如果是空矩阵 返回false
        if (matrix.length==0 || matrix[0].length==0) return false;
        // 如果矩阵中只有一个值
        if (matrix.length == 1 && matrix[0].length==1) return matrix[0][0] == target;
        return search(matrix, target);
    }

    private boolean search(int[][] arr, int target){
        for (int[] ints : arr) {
            for (int a : ints) {
                if (a == target) return true;
            }
        }
        return false;
    }

    private static int[][] genArr(int n){
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = i+j;
            }
        }
        return arr;
    }

    private boolean binarySearch(int[][] arr, int target, int x1, int y1, int x2, int y2) {
        // 如果范围内仅有一个值
        if (x1 == x2 && y1 == y2) {
            return arr[x1][y1] == target;
        }

//        if (target < arr[x1][y1] || target > arr[x2][y2]) {
//            return false;
//        }
        int midX = (x1+x2)/2;
        int midY = (y1+y2)/2;
        if (arr[midX][midY] == target){ // 中间值正好等于目标值
            return true;
        } else if (arr[midX][midY] > target){   // 目标值 小于 中值
            // 查找左上角
            if (midX > x1 && midY > y1) {
                boolean r1 = binarySearch(arr, target, x1, y1, midX - 1, midY - 1);
                if (r1) return true;
            }
            // 查找右上角
            if (midX > x1) {
                boolean r2 = binarySearch(arr, target, x1, midY, midX - 1, y2);
                if (r2) return true;
            }
            // 查找左下角
            if (midY > y1)
                return binarySearch(arr, target, midX, y1, x2, midY-1);
            return false;
        }else {         // 目标值 大于 中值
            // 查找右下角
            if (midX < x2 && midY < y2) {
                boolean r1 = binarySearch(arr, target, midX + 1, midY + 1, x2, y2);
                if (r1) return true;
            }
            // 查找右上角
            if (midY < y2) {
                boolean r2 = binarySearch(arr, target, x1, midY + 1, midX, y2);
                if (r2) return true;
            }
            // 查找左下角
            if (midX < x2)
                return binarySearch(arr, target, midX+1, y1, x2, midY);
            return false;
        }
    }


}
