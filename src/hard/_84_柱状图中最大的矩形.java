package hard;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author lz
 * @date 2021/09/29 21:28
 **/
public class _84_柱状图中最大的矩形 {

    public static void main(String[] args) {
        int[] heights = {2, 4};
        int res = largestRectangleArea(heights);
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0, n = heights.length;
        int[] left_ind = new int[n];
        int[] right_ind = new int[n];
        Arrays.fill(left_ind, -1);
        Arrays.fill(right_ind, n);
        // 单调栈法
        // 1.寻找右边<=当前数的位置
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!st.empty() && heights[i] < heights[st.peek()]) {
                right_ind[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        // 2.寻找左边<=当前数的位置
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && heights[i] < heights[st.peek()]) {
                left_ind[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        // 3.计算面积
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (right_ind[i] - left_ind[i] - 1));
        }
        return maxArea;
    }
}
