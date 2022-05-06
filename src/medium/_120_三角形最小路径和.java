package medium;

import javafx.util.Pair;

import java.util.*;

/**
 * @author lz
 * @date 2022/02/22 21:52
 **/
public class _120_三角形最小路径和 {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3, 4)));
        triangle.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        triangle.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));

        int res = minimumTotal(triangle);
    }

    /**
     * 超时
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal1(List<List<Integer>> triangle) {
        int res = triangle.get(0).get(0);
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, res));
        Pair<Integer, Integer> cur;
        for (int row = 1; row < triangle.size(); row++) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                cur = queue.poll();
                queue.add(new Pair<>(cur.getKey(), cur.getValue() + triangle.get(row).get(cur.getKey())));
                if (cur.getKey() + 1 < triangle.get(row).size()) {
                    queue.add(new Pair<>(cur.getKey() + 1, cur.getValue() + triangle.get(row).get(cur.getKey() + 1)));
                }
            }
        }
        res = Integer.MAX_VALUE;
        int n = queue.size();
        for (int i = 0; i < n; i++) {
            cur = queue.poll();
            res = Math.min(res, cur.getValue());
        }
        return res;
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int row = 1;
        int dp[][] = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (; row < triangle.size(); row++) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                if (col - 1 < 0) {
                    dp[row][col] = dp[row - 1][col] + triangle.get(row).get(col);
                } else if (col >= triangle.get(row - 1).size()) {
                    dp[row][col] = dp[row - 1][col - 1] + triangle.get(row).get(col);
                } else {
                    dp[row][col] = Math.min(dp[row - 1][col - 1], dp[row - 1][col])
                            + triangle.get(row).get(col);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dp[triangle.size() - 1].length; i++) {
            res = Math.min(res, dp[triangle.size() - 1][i]);
        }
        return res;
    }

}
