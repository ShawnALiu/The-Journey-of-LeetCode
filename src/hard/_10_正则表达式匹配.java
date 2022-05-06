package hard;

public class _10_正则表达式匹配 {
    public static void main(String[] args) {

    }

    public boolean isMatch(String s, String p) {
        // 按长度进行匹配
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        dp[0][0] = 0;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i][j - 2];
                }
            }
        }
        return false;
    }
}
