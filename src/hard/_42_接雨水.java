package hard;

/**
 * 
 * @author lz
 * @date 2021/08/01 19:40
 **/
public class _42_接雨水 {
    public static void main(String[] args) {
        int[] height = {2, 0, 2};
        int res = trap(height);
    }

    public static int trap(int[] height) {
        int maxHeightInd = 0;
        for (int i = 1; i < height.length; i++) {
            maxHeightInd = height[i] > height[maxHeightInd] ? i : maxHeightInd;
        }
        int left = 0, right = 0, res = 0;
        // 1.计算左半部分
        // right 一直向maxHeightInd靠近，当 right 到达maxHeightInd时，左半部分计算结束
        while (right < maxHeightInd) {
            if (height[right] <= height[left]) {
                res += (height[left] - height[right]);
            } else {
                left = right;
            }
            // 每次更新 right，不能贪方便，放在上面的24行里直接height[right++],会导致26行时不更新right值
            right++;
        }
        left = height.length - 1;
        right = height.length - 1;
        // 1.计算右半部分
        // left 一直向maxHeightInd靠近，当 left 到达maxHeightInd时，右半部分计算结束
        while (left > maxHeightInd) {
            if (height[left] <= height[right]) {
                res += (height[right] - height[left]);
            } else {
                right = left;
            }
            left--;
        }
        return res;
    }
}
