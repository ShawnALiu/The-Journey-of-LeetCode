package easy;

import util.ListNode;

/**
 * @author lz
 * @date 2021/09/25 22:56
 **/
public class _83_删除排序链表中的重复元素 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3};
        ListNode head = ListNode.createList(nums);
        ListNode res = deleteDuplicates(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode toInsert = dummyHead, pre = head.next, cur = head;
        while (true) {
            while (pre != null && pre.val == cur.val) {
                pre = pre.next;
            }
            toInsert.next = cur;
            toInsert = toInsert.next;
            if (pre != null) {
                cur = pre;
                pre = pre.next;
            } else {
                toInsert.next = null;
                break;
            }
        }
        return dummyHead.next;
    }
}
