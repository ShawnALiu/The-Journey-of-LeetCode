package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_三数之和 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 双指针：减少计算，second 和 third 同时向中间逼近
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[first], nums[second], nums[third]));
                }
                if (sum > 0) {
                    int right = third;
                    while (right > second && nums[right] == nums[third])
                        right--;
                    third = right;
                } else {
                    int left = second;
                    while (left < third && nums[left] == nums[second])
                        left++;
                    second = left;
                }
            }
        }
        return res;
    }
}
