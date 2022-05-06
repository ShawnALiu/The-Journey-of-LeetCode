package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18_四数之和 {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> res = fourSum(nums, target);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < nums.length - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 双指针法
                int third = second + 1, fourth = nums.length - 1;
                while (third < fourth) {
                    int sum = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                    }
                    if (sum > target) {
                        int right = fourth;
                        while (right > third && nums[right] == nums[fourth])
                            right--;
                        fourth = right;
                    } else {
                        int left = third;
                        while (left < fourth && nums[left] == nums[third])
                            left++;
                        third = left;
                    }
                }
            }
        }
        return res;
    }
}
