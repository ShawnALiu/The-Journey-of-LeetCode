package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lz
 * @date 2021/11/07 21:58
 **/
public class _102_二叉树的层序遍历 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> level = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur;
        while (!queue.isEmpty()) {
            int n = queue.size();
            level.clear();
            for (int i = 0; i < n; i++) {
                cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(new ArrayList<>(level));
        }
        return res;
    }
}
