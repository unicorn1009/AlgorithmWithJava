package mianshi.tx0811;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-08-11 3:07 下午
 */
public class Main3 {
    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressString("aabcccccaaa"));
    }

    public static String compressString(String s) {
        if (s.length() <= 2)
            return s;
        StringBuilder sb = new StringBuilder();
        // 只要遇到与前一个字符不相同的字符, 则重新开始计数
        char pre = s.charAt(0);
        int c = 0;  // 重复字符个数
        for (int i = 0; i < s.length(); i++) {
            // 如果当前字符与上一字符不同, 则得到一段压缩
            if (s.charAt(i) != pre){
                sb.append(pre);
                sb.append(c);
                c = 1;
            }else {
                // 与上一字符相同
                c++;
            }
            pre = s.charAt(i);
        }
        sb.append(pre);
        sb.append(c);
        return sb.length() >= s.length() ? s : sb.toString();

    }

}
