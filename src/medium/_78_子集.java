package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lz
 * @date 2021/09/01 22:57
 **/
public class _78_子集 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k <= nums.length; k++) {
            backtrace(res, list, nums, 0, k);
        }
        return res;
    }

    public static void backtrace(List<List<Integer>> res, List<Integer> list, int[] nums, int start, int k) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrace(res, list, nums, i + 1, k);
            list.remove(list.size() - 1);
        }
    }
}
