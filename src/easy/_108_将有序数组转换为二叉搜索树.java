package easy;

import util.TreeNode;

/**
 * @author lz
 * @date 2021/11/22 22:51
 **/
public class _108_将有序数组转换为二叉搜索树 {

    private static int[] mNums;

    public static void main(String[] args) {

    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        mNums = nums;
        TreeNode root = topToBot(0, nums.length - 1);
        return root;
    }

    public static TreeNode topToBot(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (right - left) / 2 + left;
        TreeNode root = new TreeNode(mNums[mid]);
        root.left = topToBot(left, mid - 1);
        root.right = topToBot(mid + 1, right);
        return root;
    }
}
