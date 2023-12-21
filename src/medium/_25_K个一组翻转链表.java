package medium;

import util.ListNode;

public class _25_K个一组翻转链表 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createList(nums);
        ListNode ret = reverseKGroup(head, 3);
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode first = dummy, second = dummy;
        while(first.next != null) {
            for (int i = 0; i < k; i++) {
                //题目：不够k个的部分，不需要翻转
                if (first.next == null) {
                    return dummy.next;
                }
                first = first.next;
            }

            //记录下一部分表头，并切断前后2个链表连接
            ListNode nextHead = first.next;
            first.next = null;
            ListNode curHead = second.next;

            //翻转前1条链表
            reverseList(second.next);

            //连接新旧2条链表，恢复成1条链表，方便下次翻转
            second.next = first;
            curHead.next = nextHead;

            first = curHead;
            second =curHead;
        }
        return dummy.next;
    }

    private static void reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        reverseList(head.next);
        head.next.next = head;
        head.next = null;
    }

}
