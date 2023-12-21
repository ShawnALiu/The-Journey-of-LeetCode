package util;

/**
 * 带随机节点的链表
 */
public class RListNode {

    public int val;
    public RListNode next;
    public RListNode random;

    public RListNode() {}
    public RListNode(int val) {
        this.val = val;
    }
    public RListNode(int val, RListNode next) {
        this.val = val;
        this.next = next;
    }
}
