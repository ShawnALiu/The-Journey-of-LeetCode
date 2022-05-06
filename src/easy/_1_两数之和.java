package easy;

import java.util.HashMap;

public class _1_两数之和 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> need = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (need.containsKey(target - nums[i])) {
                return new int[] {i, need.get(target - nums[i])};
            } else {
                need.put(nums[i], i);
            }
        }
        return null;
    }

}
