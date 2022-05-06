package medium;

import java.util.Arrays;

public class _16_最接近的三数之和 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128};
        int target = 82;
        int res = threeSumClosest(nums, target);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 10000000;

        // 枚举 first
        for (int first = 0; first < n; ++first) {
            // 保证和上一次枚举的元素不相等
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 使用双指针枚举 second 和 third
            int second = first + 1, third = n - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 third 对应的指针
                    int k = third - 1;
                    // 移动到下一个不相等的元素
                    while (second < k && nums[k] == nums[third]) {
                        --k;
                    }
                    third = k;
                } else {
                    // 如果和小于 target，移动 second 对应的指针
                    int j = second + 1;
                    // 移动到下一个不相等的元素
                    while (j < third && nums[j] == nums[second]) {
                        ++j;
                    }
                    second = j;
                }
            }
        }
        return res;
    }

}
