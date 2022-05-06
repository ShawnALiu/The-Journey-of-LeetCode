package medium;

import util.TreeNode;

import java.util.*;

/**
 * @author lz
 * @date 2021/11/14 21:44
 **/
public class _107_二叉树的层序遍历II {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        TreeNode cur;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            level.clear();
            int n = que.size();
            for (int i = 0; i < n; i++) {
                cur = que.poll();
                level.add(cur.val);
                if (cur.left != null) que.add(cur.left);
                if (cur.right != null) que.add(cur.right);
            }
            res.add(new ArrayList<>(level));
        }
        Collections.reverse(res);
        return res;
    }
}
