package hard;

/**
 * 
 * @author lz
 * @date 2021/08/02 21:45
 **/
public class _44_通配符匹配 {

    public static void main(String[] args) {
        String s = "acdcb", p = "a*c?b";
        boolean res = isMatch(s, p);
    }

    public static boolean isMatch(String s, String p) {
        // 1. i，j表示s的第i个字母与p的第j个字母是否匹配
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // 2. 空字符匹配
        dp[0][0] = true;
        // 3. 看p有连续几个‘*’
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }
        // 4. 动态规划
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                // 5. 当前位置匹配，则各往前看一位
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                    // 6. 若p为‘*’，则判断是否使用'*'，'*'可以当空，也可以为任意字符串
                } else if (p.charAt(j - 1) == '*') {
                    // 7. 若不使用'*'，则看dp[i][j-1]
                    // 若使用'*'，则看dp[i - 1][j]
                    dp[i][j] = (dp[i - 1][j] || dp[i][j - 1]);
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
