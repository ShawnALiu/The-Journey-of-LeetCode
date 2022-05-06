package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lz
 * @date 2021/08/05 22:13
 **/
public class _46_全排列 {

    public static void main(String[] args) {
        int[] nums = {0, 1};
        List<List<Integer>> res = permute(nums);
    }

    public static List<List<Integer>> permute(int[] nums) {
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
            if (exist[i] == 1) {
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
