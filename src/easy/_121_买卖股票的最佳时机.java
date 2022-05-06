package easy;

/**
 * @author lz
 * @date 2022/05/06 22:04
 **/
public class _121_买卖股票的最佳时机 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int res = maxProfit(prices);
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int maxProfit = 0;

        int fast = 0, slow = 0;
        while (fast < len) {
            if (prices[fast] < prices[slow]) {
                slow = fast;
            } else {
                maxProfit = Math.max(maxProfit, prices[fast] - prices[slow]);
            }
            fast++;
        }
        return maxProfit;

    }

}
