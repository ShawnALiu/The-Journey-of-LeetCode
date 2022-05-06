package medium;

import util.ListNode;
import util.TreeNode;

/**
 * @author lz
 * @date 2021/11/22 23:05
 **/
public class _109_有序链表转换二叉搜索树 {

    public static void main(String[] args) {

    }

    public static TreeNode sortedListToBST(ListNode head) {
        return topToBot(head, null);
    }


    public static TreeNode topToBot(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMid(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = topToBot(left, mid);
        root.right = topToBot(mid.next, right);
        return root;
    }

    public static ListNode getMid(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
