package medium;

import util.ListNode;

import java.util.LinkedList;
import java.util.List;

public class _142_环形链表Ⅱ {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;


        //ListNode ret = detectCycle(node1);
        ListNode retV2 = detectCycleV2(node1);

    }

    /**
     * 假设链表如下，入环前有m个节点（+表示），环长度为n个节点（-表示）
     * +++++-----
     *      -   -
     *      -----
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        //快慢指针都先走一步，如果初始化在dummyHead，快慢指针直接相等了
        ListNode slow = head, fast = head.next;
        //第三个指针，要把入环前的m步走完，则需要初始化在dummyHead
        ListNode cur = new ListNode();
        cur.next = head;
        while(fast != null && fast.next != null) {
            if (slow == fast) {
                while(cur != slow) {
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

    /**
     * 题解代码
     */
    public static ListNode detectCycleV2(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        //3个点的起点要保持一致
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
