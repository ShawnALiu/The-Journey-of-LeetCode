package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lz
 * @date 2021/12/01 22:14
 **/
public class _113_路径总和II {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        helper(res, nums, root, targetSum);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> nums, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        nums.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && 0 == targetSum) {
            res.add(new ArrayList<>(nums));
        }
        helper(res, nums, root.left, targetSum);
        helper(res, nums, root.right, targetSum);
        nums.remove(nums.size() - 1);
    }
}
