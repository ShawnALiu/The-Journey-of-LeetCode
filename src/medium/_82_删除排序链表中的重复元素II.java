package medium;

import util.ListNode;

/**
 * @author lz
 * @date 2021/09/25 22:12
 **/
public class _82_删除排序链表中的重复元素II {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 4, 5};
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
            if (cur.next == pre) {
                toInsert.next = cur;
                if (pre != null) {
                    toInsert = toInsert.next;
                    cur = pre;
                    pre = pre.next;
                } else {
                    break;
                }
            } else {
                if (pre == null) {
                    toInsert.next = null;
                    break;
                } else {
                    cur = pre;
                    pre = pre.next;
                }
            }
        }
        return dummyHead.next;
    }
}
