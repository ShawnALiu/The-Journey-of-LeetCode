package medium;

/**
 * 
 * @author lz
 * @date 2021/07/28 22:18
 **/
public class _38_外观数列 {

    public static void main(String[] args) {
        int n = 4;
        String res = countAndSay(n);
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        int left = 0, right = 0;
        // 在最后添加一个结束符，否则导致最后一部分重复数字没有添加到sb中
        String s1 = countAndSay(n - 1) + "X";
        while (right < s1.length()) {
            if (s1.charAt(right) != s1.charAt(left)) {
                sb.append(right - left).append(s1.charAt(left));
                left = right;
            }
            right++;
        }
        return sb.toString();
    }
}
