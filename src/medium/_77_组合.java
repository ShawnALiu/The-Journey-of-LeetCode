package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lz
 * @date 2021/09/01 22:39
 **/
public class _77_组合 {

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> res = combine(n, k);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrace(res, list, 1, n, k);
        return res;
    }

    public static void backtrace(List<List<Integer>> res, List<Integer> list, int start, int n, int k) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrace(res, list, i + 1, n, k);
            list.remove(list.size() - 1);
        }
    }
}
