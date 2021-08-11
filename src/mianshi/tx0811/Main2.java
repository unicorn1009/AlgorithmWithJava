package mianshi.tx0811;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-08-11 2:57 下午
 */
public class Main2 {
    public static void main(String[] args) {
        System.out.println(maxLen("abbbbcccddddddddeee"));
    }

    public static String maxLen(String s){
        int start = 0;
        int maxLen = 0;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (i-1 >= 0 && s.charAt(i) == s.charAt(i-1)){
                continue;
            }else { // 与前一个字符不等
                if (i - start > maxLen){
                    ans = s.substring(start, i);
                }
                maxLen = Math.max(maxLen, i - start);
                start = i;
            }

        }
        if (s.length() - start > maxLen){
            ans = s.substring(start);
        }
        return ans;
    }
}
