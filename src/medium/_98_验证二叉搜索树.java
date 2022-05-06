package medium;

import util.TreeNode;

/**
 * @author lz
 * @date 2021/11/01 23:56
 **/
public class _98_验证二叉搜索树 {

    public static void main(String[] args) {

    }

    public static boolean isValidBST(TreeNode root) {
        return help(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 必须 long 类型，否则边界出问题
     *
     * @param root
     * @param min
     * @param max
     * @return
     */
    public static boolean help(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }
        return help(root.left, min, root.val) && help(root.right, root.val, max);
    }
}
