package util;

/**
<<<<<<< HEAD
=======
 * 链表
 *
>>>>>>> bcec54e (leetcode)
 * @author lz
 * @date 2021/07/16 22:52
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createList(int[] nums) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        for (int n : nums) {
            cur.next = new ListNode(n);
            cur = cur.next;
        }
        return dummyHead.next;
    }

    public static ListNode[] createArrayList(int[][] arrays) {
        ListNode[] lists = new ListNode[arrays.length];

        for (int i = 0; i < arrays.length; i++) {
            lists[i] = createList(arrays[i]);
        }
        return lists;
    }

    public static ListNode reverseList(ListNode list) {
        if (list == null || list.next == null) {
            return list;
        }
        ListNode revHead = reverseList(list.next);
        list.next.next = list;
        list.next = null;
        return revHead;
    }
}
