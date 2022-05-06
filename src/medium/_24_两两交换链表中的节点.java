package medium;

import util.ListNode;

/**
 * @author lz
 * @date 2021/07/17 22:44
 **/
public class _24_两两交换链表中的节点 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode head = ListNode.createList(nums);
        ListNode res = swapPairs(head);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 因为需要交换A,B两个节点，因此需要定位A,B的父节点
        ListNode first, second;
        // 哨兵节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        first = dummyHead;
        second = dummyHead;

        while (first.next != null) {
            // 更新first
            first = first.next.next;
            // 长度为奇数时， 将剩下一个节点，此时 first 指向 null
            if (first == null) {
                break;
            }
            // 交换相邻节点
            second.next.next = first.next;
            first.next = second.next;
            second.next = first;
            // 将 first, second 回复到下一次交换的起始位置
            first = first.next;
            second = first;
        }
        return dummyHead.next;
    }
}
