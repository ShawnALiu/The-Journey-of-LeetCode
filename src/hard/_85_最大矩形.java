package hard;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author lz
 * @date 2021/09/29 22:19
 **/
public class _85_最大矩形 {

    public static void main(String[] args) {
        //char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix = {{'1'}};
        int res = maximalRectangle(matrix);
    }

    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m <= 0)
            return 0;
        int n = matrix[0].length;
        if (n <= 0)
            return 0;
        // 1.计算长度
        // leftOneNum[i][j]表示第i行中，第j位左边连续的'1'
        int[][] leftOneNum = new int[m][n];
        for (int i = 0; i < m; i++) {
            Stack<Integer> st = new Stack<>();
            for (int j = n - 1; j >= 0; j--) {
                while (!st.empty() && matrix[i][j] == '0') {
                    leftOneNum[i][st.peek()] = st.peek() - j;
                    st.pop();
                }
                if (matrix[i][j] == '1') {
                    st.push(j);
                }
            }
            while (!st.empty()) {
                leftOneNum[i][st.peek()] = st.peek() + 1;
                st.pop();
            }
        }
        // 2.计算最大矩形，同84题
        int maxArea = 0, maxRowArea = 0;
        for (int j = 0; j < n; j++) {
            maxRowArea = largestRectangleArea(leftOneNum, j);
            maxArea = Math.max(maxArea, maxRowArea);
        }
        return maxArea;
    }

    // 84题，计算最大矩形
    // 这里换个方向，竖着计算
    public static int largestRectangleArea(int[][] heights, int col) {
        int m = heights.length;
        int[] botInd = new int[m], topInd = new int[m];
        Arrays.fill(botInd, m);
        Arrays.fill(topInd, -1);
        Stack<Integer> st = new Stack<>();
        // 1.向下寻找第一个小于的数
        for (int i = 0; i < m; i++) {
            while (!st.empty() && heights[i][col] < heights[st.peek()][col]) {
                botInd[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        // 2.向上寻找第一个小于的数
        for (int i = m - 1; i >= 0; i--) {
            while (!st.empty() && heights[i][col] < heights[st.peek()][col]) {
                topInd[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        // 3.计算面积
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            maxArea = Math.max(maxArea, heights[i][col] * (botInd[i] - topInd[i] - 1));
        }
        return maxArea;
    }
}
