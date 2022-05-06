package medium;

import java.awt.*;

/**
 * 
 * @author lz
 * @date 2021/08/05 23:01
 **/
public class _48_旋转图像 {

    public static void main(String[] args) {
        // int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        // int[][] matrix = {{1}};
        int[][] matrix = {{1, 2}, {3, 4}};
        rotate(matrix);
    }

    // 用一张草稿纸作坐标转换，坐标系为图像坐标系（即左上角为原点，左手坐标系），得到
    // x'=N-1-y,y'=x
    // 旋转时，只用把1/4进行旋转，
    // 如果是奇数，去掉中心点，(N^2-1)/4=(N-1)/2*(N+1)/2,即遍历(N-1)/2，(N+1)/2
    // 如果是偶数，无需去掉中心点，(N^2)/4=(N/2）*(N/2）,即遍历N/2，N/2
    public static void rotate(int[][] matrix) {
        int N = matrix.length, xN, yN;
        if (N % 2 == 0) {
            xN = N / 2;
            yN = N / 2;
        } else {
            xN = (N - 1) / 2;
            yN = (N + 1) / 2;
        }
        for (int x = 0; x < xN; x++) {
            for (int y = 0; y < yN; y++) {
                int tmp1, tmp2;
                Point trans = new Point(x, y);
                tmp1 = matrix[trans.y][trans.x];
                for (int i = 0; i < 4; i++) {
                    trans = new Point(N - 1 - trans.y, trans.x);
                    tmp2 = matrix[trans.y][trans.x];
                    matrix[trans.y][trans.x] = tmp1;
                    tmp1 = tmp2;
                }
            }
        }
    }
}
