package medium;

/**
 * @author lz
 * @date 2021/08/27 22:38
 **/
public class _73_矩阵置零 {

    public static void main(String[] args) {
        int[][] matrix = {{2147483647}, {2}, {3}};
        setZeroes(matrix);
    }

    // 将第一行，第一列作为标志位，记录后面行，列有没有0
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 另设2个参数，记录第1行，第1列
        boolean row0 = false, col0 = false;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row0 = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }

        // 遍历其他行列，记录情况
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // 第i行有0
                    matrix[i][0] = 0;
                    // 第j列有0
                    matrix[0][j] = 0;
                }
            }
        }
        // 开始置0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 处理第1行，第1列
        if (row0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
