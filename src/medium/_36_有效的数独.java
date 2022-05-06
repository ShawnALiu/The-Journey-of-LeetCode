package medium;

/**
 * 
 * @author lz
 * @date 2021/07/27 21:58
 **/
public class _36_有效的数独 {

    public static void main(String[] args) {
        char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        boolean res = isValidSudoku(board);
    }

    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] block = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int n = board[i][j] - '1';
                int k = i / 3 * 3 + j / 3;
                if (row[i][n] == 1 || col[j][n] == 1 || block[k][n] == 1) {
                    return false;
                }
                row[i][n] = 1;
                col[j][n] = 1;
                block[k][n] = 1;
            }
        }
        return true;
    }
}
