package easy;

import util.TreeNode;

/**
 * @author lz
 * @date 2021/11/23 23:16
 **/
public class _111_二叉树的最小深度 {

    public static void main(String[] args) {

    }

    public static int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
        if (root.left != null) {
            return 1 + minDepth(root.left);
        }
        if (root.right != null) {
            return 1 + minDepth(root.right);
        }
        return 0;
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth, minDepth(root.left));
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth, minDepth(root.right));
        }
        return 1 + minDepth;
    }
}
