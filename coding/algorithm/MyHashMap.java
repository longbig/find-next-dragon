package algorithm;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author yuyunlong
 * @date 2021/3/14 11:38 下午
 * @description
 */
public class MyHashMap {

    private LinkedList[] linkedLists;
    private int base = 857;

    /** Initialize your data structure here. */
    public MyHashMap() {
        linkedLists = new LinkedList[base];
        for (int i = 0; i < base; i++) {
            linkedLists[i] = new LinkedList<Pair>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hash(key);
        Iterator<Pair> iterator = linkedLists[index].iterator();
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.getKey() == key) {
                pair.setValue(value);
                return;
            }
        }
        Pair temp = new Pair(key, value);
        linkedLists[index].offerLast(temp);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hash(key);
        Iterator<Pair> iterator = linkedLists[index].iterator();
        while (iterator.hasNext()) {
            Pair temp = iterator.next();
            if (temp.getKey() == key) {
                return temp.value;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hash(key);
        Iterator<Pair> iterator = linkedLists[index].iterator();
        while (iterator.hasNext()) {
            Pair temp = iterator.next();
            if (temp.key == key) {
                linkedLists[index].remove(temp);
                return;
            }
        }
    }

    private int hash(int key) {
        return key % base;
    }

    private class Pair {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

}
