package medium;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lz
 * @date 2021/10/25 23:24
 **/
public class _95_不同的二叉搜索树II {

    public static void main(String[] args) {

    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return help(1, n);
    }

    public static List<TreeNode> help(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            //计算左子树
            List<TreeNode> leftTrees = help(start, i - 1);
            //计算右子树
            List<TreeNode> rightTrees = help(i + 1, end);
            //从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode curRoot = new TreeNode(i);
                    curRoot.left = left;
                    curRoot.right = right;
                    allTrees.add(curRoot);
                }
            }
        }
        return allTrees;
    }
}
