package mianshi.bd0812;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-08-12 8:36 下午
 */
public class T2 {
    public static void main(String[] args) {
        System.out.println(sqrt(5));
        System.out.println(Math.sqrt(5));   // 2.23606797749979
    }

    public static double sqrt(int x){
        double i = 0.000001;
        double left = 0, right = x;
        double ans = -1;
        while (right - left >= i){
            double mid = (left + right) / 2;
            if (Math.abs(mid * mid - x )<= i){
                ans = mid;
                return mid;
            }else {
                if (mid * mid < x){
                    left = mid+i;
                }else {
                    right = mid-i;
                }
            }
        }
        return ans;
    }
}
