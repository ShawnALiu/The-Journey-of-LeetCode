package medium;

import util.TreeNode;

/**
 * @author lz
 * @date 2021/11/08 22:46
 **/
public class _104_二叉树的最大深度 {

    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


}
