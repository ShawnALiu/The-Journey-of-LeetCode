package easy;

import util.TreeNode;

/**
 * @author lz
 * @date 2021/11/23 23:07
 **/
public class _110_平衡二叉树 {

    public static void main(String[] args) {

    }

    //解法1：自顶向下
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;

    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    //解法2：自底向上


}
