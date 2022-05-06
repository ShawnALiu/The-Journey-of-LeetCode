package easy;

/**
 * @author lz
 * @date 2021/08/24 23:16
 **/
public class _70_爬楼梯 {
    public static void main(String[] args) {
        int n = 3;
        int res = climbStairs(n);
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
