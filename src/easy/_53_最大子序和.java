package easy;

/**
 * 
 * @author lz
 * @date 2021/08/10 23:27
 **/
public class _53_最大子序和 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = maxSubArray(nums);
    }

    public static int maxSubArray1(int[] nums) {
        int maxSum = 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    // 我们用 f(i) 代表以第 i 个数结尾的「连续子数组的最大和」
    // 状态转移方程： f(i)=max{f(i−1)+nums[i],nums[i]}
    // 对 maxSubArray 进行优化
    // 只用一个变量 preSum 来维护对于当前 f(i) 的 f(i-1) 的值是多少，
    // 从而让空间复杂度降低到 O(1)，这有点类似「滚动数组」的思想。
    public static int maxSubArray(int[] nums) {
        int preSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum = Math.max(preSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }
}
