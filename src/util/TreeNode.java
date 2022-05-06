package util;

/**
 * @author lz
 * @date 2021/10/20 23:33
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


//    public static TreeNode creatTreeNode(int[] nums) {
//        if (nums.length == 0) {
//            return null;
//        }
//
//    }
}
