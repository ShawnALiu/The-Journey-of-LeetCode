package hard;

import util.TreeNode;

/**
 * @author lz
 * @date 2022/07/10 20:26
 **/
public class _124_二叉树中的最大路径和 {

    public static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {

    }

    public static int maxPathSum(TreeNode root) {
        curPathMax(root);
        return maxSum;
    }

    public static int curPathMax(TreeNode node) {
        if (node == null) {
            return 0;
        }

        //计算左右路径最大值
        int leftPathMax = Math.max(curPathMax(node.left), 0);
        int rightPathMax = Math.max(curPathMax(node.right), 0);

        //更新当前节点的最大值
        maxSum = Math.max(maxSum, leftPathMax + rightPathMax + node.val);

        return node.val + Math.max(leftPathMax, rightPathMax);
    }


}
