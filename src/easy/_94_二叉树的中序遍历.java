package easy;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lz
 * @date 2021/10/20 23:33
 **/
public class _94_二叉树的中序遍历 {

    public static void main(String[] args) {

    }

    /**
     * 中序遍历： 左 -> 根 -> 右
     *
     * @param root 根节点
     * @return 遍历结果
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> res = new ArrayList<>();
        if (root.left != null) {
            res.addAll(inorderTraversal(root.left));
        }
        res.add(root.val);
        if (root.right != null) {
            res.addAll(inorderTraversal(root.right));
        }
        return res;
    }

    /**
     * 非递归
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode cur;
        while (!st.empty()) {
            cur = st.peek();
            st.pop();
            if (cur != null) {
                if (cur.right != null) st.push(cur.right);
                st.push(cur);
                st.push(null);
                if (cur.left != null) st.push(cur.left);
            } else {
                res.add(st.peek().val);
                st.pop();
            }
        }
        return res;
    }
}
