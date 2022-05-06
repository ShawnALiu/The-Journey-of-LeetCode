package medium;

/**
 * @author lz
 * @date 2021/11/01 23:22
 **/
public class _97_交错字符串 {

    public static void main(String[] args) {

    }


    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i > 0 && s3.charAt(i + j - 1) == s1.charAt(i - 1))
                    dp[i][j] |= dp[i - 1][j];
                if (j > 0 && s3.charAt(i + j - 1) == s2.charAt(j - 1))
                    dp[i][j] |= dp[i][j - 1];
            }
        }
        return dp[s1.length()][s2.length()] == 1;
    }

    /**
     * 滚动数组，进行空间优化
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[] dp = new boolean[s2.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i > 0)
                    dp[j] &= (s3.charAt(i + j - 1) == s1.charAt(i - 1));
                if (j > 0)
                    dp[i] |= (s3.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }
        return dp[s2.length()];
    }
}
