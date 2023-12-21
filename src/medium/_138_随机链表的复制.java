package medium;

import util.RListNode;

import java.util.HashMap;
import java.util.Map;

public class _138_随机链表的复制 {

    public RListNode copyRandomList(RListNode head) {
        if (head == null) {
            return null;
        }
        Map<RListNode, RListNode> mp = new HashMap<>();

        RListNode dummy = new RListNode(0);
        RListNode cur1 = dummy, cur2 = head;
        while(cur2 != null) {
            RListNode newNode = new RListNode(cur2.val);
            cur1.next = newNode;
            mp.put(cur2, newNode);

            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        cur1 = dummy.next;
        cur2 = head;
        while(cur2 != null) {
            cur1.random = mp.get(cur2.random);
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return dummy.next;
    }

}
