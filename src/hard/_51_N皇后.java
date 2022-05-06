package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author lz
 * @date 2021/08/08 00:46
 **/
public class _51_N皇后 {

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = solveNQueens(n);
        // System.out.println(res.get(0).get(0));
        // System.out.println(res.get(0).get(0).length());
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        List<Integer> placed = new ArrayList<>(Collections.nCopies(n, -1));
        backtrack(lists, list, placed, 0, n);
        return lists;
    }

    public static void backtrack(List<List<String>> lists, List<String> list, List<Integer> placed, int row, int n) {
        if (row == n) {
            lists.add(new ArrayList<>(list));
            return;
        }
        List<String> sb = new ArrayList<>(Collections.nCopies(n, "."));
        for (int col = 0; col < n; col++) {
            if (check(placed, row, col)) {
                placed.set(row, col);
                sb.set(col, "Q");
                list.add(String.join("", sb));
                backtrack(lists, list, placed, row + 1, n);
                list.remove(list.size() - 1);
                sb.set(col, ".");
                placed.set(row, -1);
            }
        }
    }

    public static boolean check(List<Integer> placed, int row, int col) {
        for (int i = 0; i < placed.size(); i++) {
            // 同一行，或者该行没有设置Q
            if (i == row || placed.get(i) == -1) {
                continue;
            }
            if (placed.get(i) == col || (col - placed.get(i)) == (row - i) || (col - placed.get(i)) == -(row - i)) {
                return false;
            }
        }
        return true;
    }
}
