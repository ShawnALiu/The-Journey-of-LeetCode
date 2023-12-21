package medium;

import util.ListNode;

public class _148_排序链表 {

    public static void main(String[] args) {
        int[] nums = {4,2,1,3};
        ListNode head = ListNode.createList(nums);
        ListNode ret = sortList(head);
    }

    public static ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        int totalLen = 0;
        ListNode cur = dummy;
        while(cur.next != null) {
            totalLen++;
            cur = cur.next;
        }


        for (int len = 1; len < totalLen; len = len * 2) {
            //由于每个for循环后，节点位置都会给改变，因此只能用dummy.next表示头节点，而非head
            ListNode left = dummy.next;
            cur = dummy;

            while(left != null) {
                ListNode right = cutList(left, len);
                ListNode nextHead = cutList(right, len);
                cur.next = mergeTwo(left, right);
                while(cur.next != null) {
                    cur = cur.next;
                }
                left = nextHead;
            }

        }
        return dummy.next;
    }

    private static ListNode cutList(ListNode head, int len) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while(len != 0 && cur.next != null) {
            len--;
            cur = cur.next;
        }

        ListNode nextHead = cur.next;
        cur.next = null;
        return nextHead;
    }

    private  static ListNode mergeTwo(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
                cur = cur.next;
            } else {
                cur.next = right;
                right = right.next;
                cur = cur.next;
            }
        }
        cur.next = left == null ? right : left;
        return dummy.next;
    }

}
