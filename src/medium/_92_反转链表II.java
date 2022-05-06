package medium;

import util.ListNode;

/**
 * @author lz
 * @date 2021/10/19 23:10
 **/
public class _92_反转链表II {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int left = 2, right = 4;
        ListNode head = ListNode.createList(nums);
        ListNode res = reverseBetween(head, left, right);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(1);
        dummyHead.next = head;
        ListNode preLeftNode = null, rightNode = null, nextRightNode, cur = dummyHead;
        while (cur != null) {
            if (left == 1) {
                preLeftNode = cur;
            }
            if (right == 0) {
                rightNode = cur;
            }
            cur = cur.next;
            left--;
            right--;
        }
        //
        nextRightNode = rightNode.next;
        rightNode.next = null;
        ListNode subHead = reverseListNode(preLeftNode.next);
        preLeftNode.next.next = nextRightNode;
        preLeftNode.next = rightNode;
        return preLeftNode == dummyHead ? preLeftNode.next : dummyHead.next;
    }

    public static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }
}
