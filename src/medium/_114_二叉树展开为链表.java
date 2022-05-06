package medium;

import util.TreeNode;

/**
 * @author lz
 * @date 2021/12/04 21:30
 **/
public class _114_二叉树展开为链表 {

    public static void main(String[] args) {
        //int[] nums = {1, 2, 5, 3, 4, null, 6};
        TreeNode root = creatTreeNode();
        flatten(root);
    }

    public static void flatten(TreeNode root) {
        TreeNode dummyHead = new TreeNode(0);
        TreeNode pre = dummyHead;
        preOrder(root, pre, dummyHead);
        root = dummyHead.right;
    }

    public static void preOrder(TreeNode root, TreeNode pre, TreeNode dummyHead) {
        if (root == null) {
            return;
        }
        pre.left = null;
        pre.right = root;
        TreeNode tmpLeft = root.left;
        TreeNode tmpRight = root.right;
        pre = pre.right;

        if (tmpLeft != null) {
            preOrder(tmpLeft, pre, dummyHead);
        }
        if (tmpRight != null) {
            preOrder(tmpRight, pre, dummyHead);
        }
    }

    public static TreeNode creatTreeNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        return root;
    }
}
