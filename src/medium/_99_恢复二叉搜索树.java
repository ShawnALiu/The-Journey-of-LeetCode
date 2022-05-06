package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lz
 * @date 2021/11/03 22:30
 **/
public class _99_恢复二叉搜索树 {

    public static void main(String[] args) {

    }

    public static void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<Integer>();
        nums = inorder(root);
        int[] swapped = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        if (root == null) {
            return nums;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode cur;
        while (!st.empty()) {
            cur = st.peek();
            st.pop();
            if (cur != null) {
                if (cur.right != null) {
                    st.push(cur.right);
                }
                st.push(cur);
                st.push(null);
                if (cur.left != null) {
                    st.push(cur.left);
                }
            } else {
                nums.add(st.peek().val);
                st.pop();
            }
        }
        return nums;
    }


    public static int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int index1 = -1, index2 = -1;
        for (int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                index2 = i + 1;
                if (index1 == -1) {
                    index1 = i;
                } else {
                    break;
                }
            }
        }
        int x = nums.get(index1), y = nums.get(index2);
        return new int[]{x, y};
    }


    public static void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }

}
