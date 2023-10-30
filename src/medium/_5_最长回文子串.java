package medium;

public class _5_最长回文子串 {
    public static void main(String[] args) {
        String s = "cbbd";
        String res = longestPalindrome(s);

    }

    /**
     * 动态规划，dp[i][j] = dp[i+1][j-1] && s[i]==s[j] ? 1:0;
     */
    public static String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";
        int start = 0, longest = 0;
        int dp[][] = new int[s.length()][s.length()];
        for (int l = 1; l <= s.length(); l++) {
            for (int i = 0; l - 1 + i < s.length(); i++) {
                if (l == 1) {
                    dp[i][l - 1 + i] = 1;
                } else if (l == 2) {
                    dp[i][l - 1 + i] = s.charAt(i) == s.charAt(l - 1 + i) ? 1 : 0;
                } else {
                    dp[i][l - 1 + i] = (dp[i + 1][l - 2 + i] == 1 && s.charAt(i) == s.charAt(l - 1 + i)) ? 1 : 0;
                }
                if (dp[i][l - 1 + i] == 1) {
                    if (l > longest) {
                        longest = l;
                        start = i;
                    }
                }
            }
        }

        // substring(start, end),从下标start开始取到下标end，但不包含end,即[start, end)
        return s.substring(start, longest + start);
    }
}
