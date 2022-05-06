package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author lz
 * @date 2021/07/29 22:55
 **/
public class _40_组合总和II {

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = combinationSum2(candidates, target);

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        dfs(candidates, ans, nums, 0, target);
        return ans;
    }

    public static void dfs(int[] candidates, List<List<Integer>> ans, List<Integer> nums, int ind, int res) {
        if (res == 0) {
            ans.add(new ArrayList<>(nums));
            return;
        }
        for (int i = ind; i < candidates.length && candidates[i] <= res; i++) {
            // 从 ind 之后，不能和前一个数字相等，这是保证在同一轮中，不会出现使用过的数字
            if (i > ind && candidates[i] == candidates[i - 1])
                continue;
            nums.add(candidates[i]);
            res -= candidates[i];
            dfs(candidates, ans, nums, i + 1, res);
            res += candidates[i];
            nums.remove(nums.size() - 1);
        }
    }
}
