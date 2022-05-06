package medium;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lz
 * @date 2021/11/07 22:07
 **/
public class _103_二叉树的锯齿形层序遍历 {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<Integer> level = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode cur;
        int order = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            level.clear();
            for (int i = 0; i < n; i++) {
                if (order % 2 == 0) {
                    cur = queue.pollFirst();
                    level.add(cur.val);
                    if (cur.left != null) {
                        queue.addLast(cur.left);
                    }
                    if (cur.right != null) {
                        queue.addLast(cur.right);
                    }
                } else {
                    cur = queue.pollLast();
                    level.add(cur.val);
                    if (cur.right != null) {
                        queue.addFirst(cur.right);
                    }
                    if (cur.left != null) {
                        queue.addFirst(cur.left);
                    }
                }
            }
            order++;
            res.add(new ArrayList<>(level));
        }
        return res;
    }

}
