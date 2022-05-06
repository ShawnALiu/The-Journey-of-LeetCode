package medium;

/**
 * @author lz
 * @date 2021/10/12 23:21
 **/
public class _91_解码方法 {

    public static void main(String[] args) {
        //String s = "111111111111111111111111111111111111111111111";
        String s = "2101";
        int res = numDecodings(s);
    }

    public static int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            int a = 0, b = 0;
            //取1位
            if (s.charAt(i - 1) != '0') {
                a = dp[i - 1];
            }
            //取2位
            if (i >= 2 && s.charAt(i - 2) != '0') {
                String word = s.substring(i - 2, i);
                int num = Integer.parseInt(word);
                if (num >= 1 && num <= 26) {
                    b = dp[i - 2];
                }
            }
            dp[i] = a + b;
        }
        return dp[s.length()];
    }
}
