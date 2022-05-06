package easy;

import util.TreeNode;

/**
 * @author lz
 * @date 2021/11/07 21:52
 **/
public class _101_对称二叉树 {

    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return help(root.left, root.right);
    }

    public static boolean help(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return help(p.left, q.right) && help(p.right, q.left);
        }
        return false;
    }
}
