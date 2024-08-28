package leetcode2021.easy;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author yuyunlong
 * @date 2021/3/13 8:20 下午
 * @description
 */
public class LeetCode705 {
    private LinkedList[] linkedLists;
    private int base = 857;

    /** Initialize your data structure here. */
    public LeetCode705() {
        linkedLists = new LinkedList[base];
        for (int i = 0; i < base; i++) {
            linkedLists[i] = new LinkedList();
        }
    }

    public void add(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = linkedLists[h].iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value == key) {
                return;
            }
        }
        linkedLists[h].offerLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = linkedLists[h].iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value == key) {
                linkedLists[h].remove(value);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = linkedLists[h].iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value == key) {
                return true;
            }
        }
        return false;
    }

    private int hash(int key) {
        return key % base;
    }
}



