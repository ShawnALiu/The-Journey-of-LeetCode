package easy;

import util.ListNode;

/**
 * @author lz
 * @date 2021/07/15 22:58
 **/
public class _21_合并两个有序链表 {

    public static void main(String[] args) {
        int[] num1 = {1, 2, 4};
        int[] num2 = {1, 3, 4};
        ListNode l1 = createList(num1);
        ListNode l2 = createList(num2);

        ListNode res = mergeTwoLists(l1, l2);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur, cur1 = l1, cur2 = l2;
        ListNode res = new ListNode(0);
        cur = res;
        while (cur1 != null || cur2 != null) {
            if (cur1 == null) {
                cur.next = new ListNode(cur2.val);
                cur = cur.next;
                cur2 = cur2.next;
                continue;
            }
            if (cur2 == null) {
                cur.next = new ListNode(cur1.val);
                cur = cur.next;
                cur1 = cur1.next;
                continue;
            }
            if (cur1.val <= cur2.val) {
                cur.next = new ListNode(cur1.val);
                cur1 = cur1.next;
            } else {
                cur.next = new ListNode(cur2.val);
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        return res.next;
    }

    public static ListNode createList(int[] num) {
        ListNode head, cur;
        head = new ListNode();
        cur = head;
        for (int n : num) {
            cur.next = new ListNode(n);
            cur = cur.next;
        }
        return head.next;
    }
}
