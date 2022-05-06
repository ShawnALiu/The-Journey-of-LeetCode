package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author lz
 * @date 2021/08/05 22:29
 **/
public class _47_全排列II {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = permuteUnique(nums);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] exist = new int[nums.length];
        backtrack(lists, list, nums, exist);
        return lists;
    }

    public static void backtrack(List<List<Integer>> lists, List<Integer> list, int[] nums, int[] exist) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 该元素已使用过
            if (exist[i] == 1) {
                continue;
            }
            // 在同一轮中，该元素与上一个元素相同，exist[i - 1] == 0保证了是同一轮，没有进入下一层迭代
            if (i > 0 && nums[i] == nums[i - 1] && exist[i - 1] == 0) {
                continue;
            }
            list.add(nums[i]);
            exist[i] = 1;
            backtrack(lists, list, nums, exist);
            exist[i] = 0;
            list.remove(list.size() - 1);
        }
    }
}
