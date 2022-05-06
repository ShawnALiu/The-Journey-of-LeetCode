package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lz
 * @date 2021/07/28 22:40
 **/
public class _39_组合总和 {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> res = combinationSum(candidates, target);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        dfs(candidates, ans, nums, 0, target);
        return ans;
    }

    public static void dfs(int[] candidates, List<List<Integer>> ans, List<Integer> nums, int ind, int res) {
        if (res < 0) {
            return;
        }
        if (res == 0) {
            // ans.add(nums); 这样是浅拷贝，会随着nums清空，ans里的内容也被清空
            ans.add(new ArrayList<>(nums));
            return;
        }
        // 因为 candidates 不是有序的，所以 不能用 && candidates[i] < res 来剪枝
        for (int i = ind; i < candidates.length; i++) {
            nums.add(candidates[i]);
            res -= candidates[i];
            dfs(candidates, ans, nums, i, res);
            res += candidates[i];
            nums.remove(nums.size() - 1);
        }
    }
}
