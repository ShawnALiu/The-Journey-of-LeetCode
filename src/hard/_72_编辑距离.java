package hard;

/**
 * @author lz
 * @date 2021/08/25 23:19
 **/
public class _72_编辑距离 {

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        int res = minDistance(word1, word2);
    }

    // dp[i][j] 表示 word1 的前 i个字符与word2的前j个字符相等，需要经过的变换
    // dp[i][j] 有三种来源,取其中最小的即可：
    // （1）dp[i-1][j] word1增加一个字符
    // （2）dp[i][j-1] word1删除一个字符
    // （3）dp[i-1][j-1] word1替换一个字符，由word1的第 i个字符与word2的第j个字符是否相等，来决定是否替换
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 初始条件
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        // 状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = MinThree(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = MinThree(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static int MinThree(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
