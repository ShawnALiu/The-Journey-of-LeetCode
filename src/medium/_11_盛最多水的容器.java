package medium;

public class _11_盛最多水的容器 {
    public static void main(String[] args) {
        int[] height = new int[] {1, 2, 1};
        int res = maxArea(height);
    }

    // 使用双指针法
    // s = min(left, right)*(right - left)
    // 面积由较小的数决定，因此每次只移动较小的指针
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxS = 0, tmpS;
        while (left < right) {
            tmpS = Math.min(height[left], height[right]) * (right - left);
            maxS = Math.max(maxS, tmpS);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxS;
    }
}
