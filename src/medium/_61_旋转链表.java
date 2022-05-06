package medium;

import util.ListNode;

/**
 * @author lz
 * @date 2021/08/19 23:08
 **/
public class _61_旋转链表 {

    public static void main(String[] args) {
        int[] nums = {1};
        int k = 0;
        ListNode head = ListNode.createList(nums);
        ListNode res = rotateRight(head, k);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        int count = 0;
        ListNode dummyHead = new ListNode(), cur, tail;
        dummyHead.next = head;
        cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        // 很重要，空链表返回null
        if (count == 0) {
            return null;
        }
        k %= count;
        // 很重要，k==0时，无需旋转
        if (k == 0) {
            return head;
        }
        tail = cur;
        int dist = count - k;
        cur = dummyHead;
        while (dist > 0) {
            cur = cur.next;
            dist--;
        }
        dummyHead.next = cur.next;
        tail.next = head;
        cur.next = null;
        return dummyHead.next;
    }


}
