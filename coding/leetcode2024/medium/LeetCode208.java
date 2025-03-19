package leetcode2024.medium;

/**
 * @author yuyunlong
 * @date 2025/3/16 15:34
 * @description 前缀树
 *
 * 最优解：26叉树
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
public class LeetCode208 {

    boolean isEnd;
    LeetCode208[] next;

    public LeetCode208() {
        this.next = new LeetCode208[26];
        isEnd = false;
    }

    public void insert(String word) {
        //插入节点时就是新建节点
        char[] array = word.toCharArray();
        LeetCode208 nodes = this;
        for (int i = 0; i < array.length; i++) {
            if (nodes.next[array[i] - 'a'] == null) {
                nodes.next[array[i] - 'a'] = new LeetCode208();
            }
            nodes = nodes.next[array[i] - 'a'];
        }
        nodes.isEnd = true;
    }

    public boolean search(String word) {
        LeetCode208 node = this;
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (node.next[array[i] - 'a'] != null) {
                node = node.next[array[i] - 'a'];
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        LeetCode208 node = this;
        char[] array = prefix.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (node.next[array[i] - 'a'] != null) {
                node = node.next[array[i] - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }
}
