package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lz
 * @date 2021/10/12 22:46
 **/
public class _90_子集II {

    public static void main(String[] args) {
        int[] nums = {1};
        List<List<Integer>> res = subsetsWithDup(nums);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] picked = new int[nums.length];
        Arrays.sort(nums);
        for (int sz = 0; sz <= nums.length; sz++) {
            backtrace(res, list, nums, picked, sz, 0);
        }
        return res;
    }

    public static void backtrace(List<List<Integer>> res, List<Integer> list, int[] nums, int[] picked, int size, int ind) {
        if (list.size() == size) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = ind; nums.length - i >= size - list.size(); i++) {
            //picked[i - 1] == 0标准前一个数在该集合中没有被选择，此时若与前面的数相等，则无需再计算
            if (i > 0 && picked[i - 1] == 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            picked[i] = 1;
            backtrace(res, list, nums, picked, size, i + 1);
            list.remove(list.size() - 1);
            picked[i] = 0;
        }
    }
}
