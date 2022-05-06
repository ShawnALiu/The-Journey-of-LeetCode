package medium;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lz
 * @date 2021/11/14 21:26
 **/
public class _106_从中序与后序遍历序列构造二叉树 {

    private static Map<Integer, Integer> mInoderHmp = new HashMap<>();
    private static int[] mInorder;
    private static int[] mPostorder;
    private static int mPostInd;

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7}, postorder = {9, 15, 7, 20, 3};
        TreeNode root = buildTree(inorder, postorder);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        mInorder = inorder;
        mPostorder = postorder;
        mPostInd = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            mInoderHmp.put(mInorder[i], i);
        }
        TreeNode root = topToBot(0, inorder.length - 1);
        return root;
    }

    public static TreeNode topToBot(int inL, int inR) {
        if (inL > inR) {
            return null;
        }
        TreeNode root = new TreeNode(mPostorder[mPostInd]);
        int tmp = mPostInd;
        mPostInd--;
        root.right = topToBot(mInoderHmp.get(mPostorder[tmp]) + 1, inR);
        root.left = topToBot(inL, mInoderHmp.get(mPostorder[tmp]) - 1);
        return root;
    }
}
