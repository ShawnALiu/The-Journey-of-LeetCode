package hard;

import util.ListNode;

/**
 * @author lz
 * @date 2021/07/19 22:15
 **/
public class _25_K个一组翻转链表 {
    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        ListNode head = ListNode.createList(nums);
        ListNode res = reverseKGroup(head, k);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = head, tmp = dummyHead;
        ListNode[] al = new ListNode[k];
        int count = 0;
        while (cur != null) {
            al[count++] = cur;
            cur = cur.next;
            if (count == k) {
                tmp.next = al[al.length - 1];
                for (int i = al.length - 1; i > 0; i--) {
                    al[i].next = al[i - 1];
                }
                count = 0;
                tmp = al[0];
            }
        }
        for (int i = 0; i < count; i++) {
            tmp.next = al[i];
            tmp = tmp.next;
        }
        tmp.next = null;
        return dummyHead.next;
    }

}
