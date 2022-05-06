package medium;

/**
 * @author lz
 * @date 2021/09/01 23:08
 **/
public class _79_单词搜索 {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "SEE";
        boolean res = exist(board, word);
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        int[][] mark = new int[m][n];
        //
        boolean res = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res |= dfs(board, mark, word, i, j, 0);
            }
        }
        return res;
    }

    public static boolean dfs(char[][] board, int[][] mark, String word, int i, int j, int ind) {
        if (ind == word.length()) {
            return true;
        }
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        boolean res = false;
        if (mark[i][j] == 0 && board[i][j] == word.charAt(ind)) {
            mark[i][j] = 1;
            res |= dfs(board, mark, word, i + 1, j, ind + 1);
            res |= dfs(board, mark, word, i - 1, j, ind + 1);
            res |= dfs(board, mark, word, i, j + 1, ind + 1);
            res |= dfs(board, mark, word, i, j - 1, ind + 1);
            mark[i][j] = 0;
        }
        return res;
    }
}
