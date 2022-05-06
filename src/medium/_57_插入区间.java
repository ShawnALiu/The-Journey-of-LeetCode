package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lz
 * @date 2021/08/15 00:26
 **/
public class _57_插入区间 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] res = insert(intervals, newInterval);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int left = newInterval[0];
        int right = newInterval[1];
        for (; i < intervals.length; i++) {
            // 无重叠
            if (intervals[i][1] < left) {
                res.add(new int[]{intervals[i][0], intervals[i][1]});
            } else if (intervals[i][0] > right) {
                break;
            } else { // 有重叠
                left = Math.min(left, intervals[i][0]);
                right = Math.max(right, intervals[i][1]);
            }
        }
        // 补齐
        res.add(new int[]{left, right});
        for (; i < intervals.length; i++) {
            res.add(new int[]{intervals[i][0], intervals[i][1]});
        }
        return res.toArray(new int[res.size()][]);
    }

}
