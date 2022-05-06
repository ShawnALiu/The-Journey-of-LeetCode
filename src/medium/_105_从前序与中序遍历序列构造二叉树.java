package medium;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lz
 * @date 2021/11/08 22:50
 **/
public class _105_从前序与中序遍历序列构造二叉树 {

    public static Map<Integer, Integer> mInorderHmp = new HashMap<>();
    public static int[] mPreorder;
    public static int[] mInorder;
    public static int mPreInd = 0;

    public static void main(String[] args) {
        int[] preorder = {-1};
        int[] inorder = {-1};

        TreeNode root = buildTree(preorder, inorder);

    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        mPreorder = preorder;
        mInorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            mInorderHmp.put(inorder[i], i);
        }
        return topToBot(0, inorder.length - 1);
    }

    //前序遍历出来的： 根 -> 左 -> 右
    //遍历前序数组，根据根节点 对 中序数组进行分割
    public static TreeNode topToBot(int inL, int inR) {
        if (inL > inR) {
            return null;
        }
        TreeNode root = new TreeNode(mPreorder[mPreInd]);
        //关键点：mPreInd要在下一次迭代前，加1
        int tmpInd = mPreInd;
        mPreInd++;

        root.left = topToBot(inL, mInorderHmp.get(mPreorder[tmpInd]) - 1);
        root.right = topToBot(mInorderHmp.get(mPreorder[tmpInd]) + 1, inR);

        return root;
    }
}
