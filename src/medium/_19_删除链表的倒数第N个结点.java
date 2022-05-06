package medium;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _19_删除链表的倒数第N个结点 {

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5};
        int n = 2;
        ListNode head = createList(num);
        ListNode res = removeNthFromEnd(head, n);
    }

    // 双指针法，first 先走，最终走到 null。
    // first 与 second 之间需要隔 n 个节点，走完后，second 在倒数第 n 个节点前一个节点。
    // 得出 first 需要先走 n+1 步，此时 second 才能复制为链表头
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first, second = null, dummyHead = new ListNode(0);
        dummyHead.next = head;
        first = dummyHead;
        while (first != null) {
            first = first.next;
            n--;
            if (second != null) {
                second = second.next;
            }
            if (n == -1) {
                second = dummyHead;
            }
        }
        second.next = second.next.next;
        return dummyHead.next;
    }

    // 使用List保存节点，另外也可使用栈保存节点
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        int ind = list.size() - n - 1;
        list.get(ind).next = list.get(ind + 1).next;
        return dummyHead.next;
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
