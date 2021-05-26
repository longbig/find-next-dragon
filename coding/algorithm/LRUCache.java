package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuyunlong
 * @date 2021/5/24 11:38 下午
 * @description LeetCode146
 */
public class LRUCache {

    class DLinkNode{
        DLinkNode next;
        DLinkNode pre;
        int value;
        int key;
        DLinkNode() {
        }
        DLinkNode(int _key, int _value) {
            this.key = _key;
            this.value = _value;
        }
    }

    int size, capacity;
    Map<Integer, DLinkNode> hashMap;
    DLinkNode head, tail;

    public LRUCache(int capacity) {
        hashMap = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkNode node = hashMap.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = hashMap.get(key);
        if (node == null) {
            DLinkNode newNode = new DLinkNode(key, value);
            hashMap.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                DLinkNode res = removeTail();
                hashMap.remove(res.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private DLinkNode removeTail() {
        DLinkNode res = tail.pre;
        removeNode(res);
        return res;
    }

}
