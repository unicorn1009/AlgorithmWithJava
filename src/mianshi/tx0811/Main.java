package mianshi.tx0811;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-08-11 1:39 下午
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("aaa");


    }



    public boolean find(int[][] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int r = 0, c = cols-1;  // 右上角坐标
        while (r <= rows - 1 && c >= 0){
            if (target == matrix[r][c])
                return true;
            else if (target > matrix[r][c]){
                r++;    // 行++
            }else
                c--;    // 列--
        }
        return false;
    }
}
