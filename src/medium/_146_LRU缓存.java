package medium;

import util.DListNode;

import java.util.HashMap;
import java.util.Map;

public class _146_LRU缓存 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 0);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }

    static class LRUCache {

        private Map<Integer, DListNode> mp = new HashMap<>();
        private Integer maxCap;
        private DListNode dummyHead;
        private DListNode dummyTail;

        public LRUCache(int capacity) {
            this.maxCap = capacity;
            this.dummyHead = new DListNode();
            this.dummyTail = new DListNode();
            this.dummyHead.next = this.dummyTail;
            this.dummyTail.pre = this.dummyHead;
        }

        public int get(int key) {
            DListNode target = mp.get(key);
            if (target == null) {
                return -1;
            }
            moveToHead(target);
            return target.value;
        }

        public void put(int key, int value) {
            DListNode target = mp.get(key);
            if (target != null) {
                moveToHead(target);
                target.value = value;
                return;
            }
            target = new DListNode(key, value);
            if (mp.size() >= maxCap) {
                DListNode lastNode = delLast();
                //记得删除超出容量的节点
                mp.remove(lastNode.key);
            }
            moveToHead(target);
            mp.put(key, target);
        }

        private void delNode(DListNode target) {
            //需要判断target是否在链表中
            if (target.pre != null) {
                target.pre.next = target.next;
                target.next.pre = target.pre;
            }
        }

        private void addToHead(DListNode target) {
            DListNode first = dummyHead.next;
            first.pre = target;
            target.next = first;

            dummyHead.next = target;
            target.pre = dummyHead;
        }

        private void moveToHead(DListNode target) {
            delNode(target);
            addToHead(target);
        }

        private DListNode delLast() {
            DListNode lastNode = dummyTail.pre;
            delNode(lastNode);
            return lastNode;
        }

    }

}
