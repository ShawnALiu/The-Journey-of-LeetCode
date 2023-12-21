package util;

/**
 * 双向链表
 */
public class DListNode {

    public Integer key;

    public Integer value;

    public DListNode pre, next;

    public DListNode() {}

    public DListNode(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

}
