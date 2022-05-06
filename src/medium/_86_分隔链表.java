package medium;

import util.ListNode;

/**
 * @author lz
 * @date 2021/10/04 15:53
 **/
public class _86_分隔链表 {

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 5, 2};
        int x = 3;
        ListNode head = ListNode.createList(nums);
        ListNode res = partition(head, x);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode smallDummyHead = new ListNode(0), largeDummyHead = new ListNode(0);
        ListNode cur = head, curSmall = smallDummyHead, curLarge = largeDummyHead;
        while (cur != null) {
            if (cur.val < x) {
                curSmall.next = cur;
                curSmall = curSmall.next;
            } else {
                curLarge.next = cur;
                curLarge = curLarge.next;
            }
            cur = cur.next;
        }
        curLarge.next = null;
        curSmall.next = largeDummyHead.next;
        return smallDummyHead.next;
    }
}
