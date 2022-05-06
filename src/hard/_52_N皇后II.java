package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author lz
 * @date 2021/08/09 22:43
 **/
public class _52_N皇后II {

    public static void main(String[] args) {
        int n = 4;
        int res = totalNQueens(n);
        // System.out.println(res.get(0).get(0));
        // System.out.println(res.get(0).get(0).length());
    }

    public static int totalNQueens(int n) {
        int res = 0;
        List<Integer> placed = new ArrayList<>(Collections.nCopies(n, -1));
        res = backtrack(placed, 0, n);
        return res;
    }

    public static int backtrack(List<Integer> placed, int row, int n) {
        if (row == n) {
            return 1;
        }
        int res = 0;
        for (int col = 0; col < n; col++) {
            if (check(placed, row, col)) {
                placed.set(row, col);
                res += backtrack(placed, row + 1, n);
                placed.set(row, -1);
            }
        }
        return res;
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
