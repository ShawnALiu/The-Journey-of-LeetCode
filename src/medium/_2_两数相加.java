package medium;

import util.ListNode;

public class _2_两数相加 {

    public static void main(String[] args) {
        // write your code here
        int[] array1 = {2, 4, 3};
        int[] array2 = {5, 6, 4};
        ListNode l1 = ListNode.createList(array1);
        ListNode l2 = ListNode.createList(array2);

        ListNode res = addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode newHead = new ListNode(), cur = newHead, curL1 = l1, curL2 = l2;

        // 一定不能忘了进位 add
        while (curL1 != null || curL2 != null || add != 0) {
            cur.next = new ListNode();
            cur = cur.next;
            int val1 = 0, val2 = 0;
            if (curL1 != null) {
                val1 = curL1.val;
                curL1 = curL1.next;
            }
            if (curL2 != null) {
                val2 = curL2.val;
                curL2 = curL2.next;
            }
            int tmpSum = add + val1 + val2;
            add = tmpSum / 10;
            tmpSum %= 10;
            cur.val = tmpSum;
        }
        return newHead.next;
    }

}
