package hard;

import util.ListNode;

import static util.ListNode.createArrayList;

/**
 * @author lz
 * @date 2021/07/16 22:34
 **/
public class _23_合并K个升序链表 {

    public static void main(String[] args) {
        int[][] arrays = {};
        ListNode[] lists = createArrayList(arrays);
        ListNode res = mergeKLists(lists);
    }

    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoList(l1, l2.next);
        return l2;
    }

    // 分治法，O(logK)
    public static ListNode merger(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];
        // 非常关键，防止输入lists空数组
        // 此外，left > right 实际上就没有合并的必要，直接返回null
        if (left > right)
            return null;
        int mid = (right - left) / 2 + left;
        return mergeTwoList(merger(lists, left, mid), merger(lists, mid + 1, right));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return merger(lists, 0, lists.length - 1);
    }
}
