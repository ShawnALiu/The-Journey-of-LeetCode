package medium;

/**
 * @author lz
 * @date 2022/05/06 22:19
 **/
public class _122_买卖股票的最佳时机II {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int res = maxProfit(prices);
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int maxProfit = 0;

        int slow = 0, fast = 0;
        while (fast < len) {
            if (prices[fast] < prices[slow]) {
                slow = fast;
            } else {
                if (fast + 1 >= len) {
                    maxProfit += Math.max((prices[fast] - prices[slow]), 0);
                } else if ((prices[fast + 1] - prices[slow]) < (prices[fast] - prices[slow])) {
                    maxProfit += prices[fast] - prices[slow];
                    slow = fast + 1;
                }
            }
            fast++;
        }
        return maxProfit;
    }

}
